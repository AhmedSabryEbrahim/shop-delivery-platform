package com.example.deliveryservice.service;

import com.example.deliveryservice.dto.CartDto;
import com.example.deliveryservice.model.Cart;
import com.example.deliveryservice.model.DeliveryDate;
import com.example.deliveryservice.model.Product;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DeliveryService {
    public static final int NUM_DAYS_FOR_EXTERNAL_PRODUCTS = 5;

    public boolean checkIfTwoDatesOnTheSameWeek(LocalDate today, LocalDate deliveryDate) {
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        return deliveryDate.isEqual(today)
                || (deliveryDate.isAfter(startOfWeek)
                && deliveryDate.isBefore(endOfWeek));
    }

    public boolean isDeliveryDateAvailable(List<Product> products,
                                           LocalDate today,
                                           int dayNumber) {

        LocalDate proposedDeliveryDate = today.plusDays(dayNumber);

        // the delivery date should be delivered on a weekday, Not (saturdays or sundays)
        if (DayOfWeek.SATURDAY.equals(proposedDeliveryDate.getDayOfWeek())
                || DayOfWeek.SUNDAY.equals(proposedDeliveryDate.getDayOfWeek())) {
            return false;
        } else {
            boolean validDeliveryDay = false;
            for (Product product : products) {
                if (product.getDeliveryDays().contains(proposedDeliveryDate.getDayOfWeek())) {
                    validDeliveryDay = true;
                    int daysInAdvance = product.getDaysInAdvance();
                    if (daysInAdvance > dayNumber) {
                        validDeliveryDay = false;
                        break;
                    }
                    if ("external".equals(product.getProductType())
                            && dayNumber < NUM_DAYS_FOR_EXTERNAL_PRODUCTS) {
                        validDeliveryDay = false;
                        break;
                    }
                    if ("temporary".equals(product.getProductType())
                            && checkIfTwoDatesOnTheSameWeek(today, proposedDeliveryDate)) {
                        validDeliveryDay = false;
                        break;
                    }
                }else {
                    // Product has no delivery on this day
                    validDeliveryDay = false;
                    break;
                }
            }
            return validDeliveryDay;
        }
    }

    public List<DeliveryDate> getAvailableDeliveryDates(Cart cart) {
        List<Product> products = cart.getProducts();
        String postalCode = cart.getPostalCode();
        LocalDate today = LocalDate.now();
        List<DeliveryDate> availableDates = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            LocalDate date = today.plusDays(i);

            if (isDeliveryDateAvailable(products, today, i)) {
                DeliveryDate deliveryDate = new DeliveryDate();
                deliveryDate.setPostalCode(postalCode);
                deliveryDate.setDeliveryDate(date.atStartOfDay());
                deliveryDate.setGreenDelivery(isGreenDelivery(date));

                // Sorting mechanism will be green delivery dates at the top of the list if they are
                //within the next 3 days, otherwise dates should just be sorted ascending.
                if (deliveryDate.isGreenDelivery() && i < 3) {
                    availableDates.add(0, deliveryDate);
                } else {
                    availableDates.add(deliveryDate);
                }
            }
        }

        availableDates.sort(
                Comparator.comparing(DeliveryDate::isGreenDelivery, Comparator.reverseOrder())
                        .thenComparing(DeliveryDate::getDeliveryDate));
        return availableDates;
    }

    private boolean isGreenDelivery(LocalDate date) {
        // TBD criteria for "green" delivery dates here.
        // For example, all Wednesdays can be considered green:
        return date.getDayOfWeek() == DayOfWeek.WEDNESDAY;
    }
}

