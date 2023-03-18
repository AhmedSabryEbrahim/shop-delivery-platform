package com.example.deliveryservice;

import com.example.deliveryservice.model.Product;
import com.example.deliveryservice.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryDateAvailabilityTest {

    private DeliveryService deliveryService;
    private List<Product>products;

    @BeforeEach
    public void setup() {
        this.deliveryService = new DeliveryService();
        this.products = TestUtil.PRODUCT_LIST;
    }

    @Test
    public void testInvalidWeekendDeliveryDate() {

        // Test a valid delivery date
        LocalDate today = LocalDate.of(2023, 3, 17); // Friday

        int dayNumber = 1; // Delivery on Saturday (invalid)
        assertFalse(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an invalid delivery date (Sunday)
        dayNumber = 2; // Delivery on Sunday (invalid)
        assertFalse(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an invalid delivery date (Monday)
        dayNumber = 3; // Delivery on Monday (Valid) however the external product require > 5 days
        assertFalse(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an valid delivery date (Monday)
        dayNumber = 10; // Delivery on Monday (Valid) however the external product require > 5 days
        assertTrue(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an invalid delivery date (Tuesday) because not all products can be delivered in tuesday
        dayNumber = 4; // Delivery on Tuesday (Invalid)
        assertFalse(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an invalid delivery date (Wednesday)
        dayNumber = 5; // Delivery on Wednesday (Valid)
        assertTrue(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));

        // Test an invalid delivery date (Thursday)
        dayNumber = 6; // Delivery on Thursday (invalid) not available for all
        assertFalse(deliveryService.isDeliveryDateAvailable(products, today, dayNumber));


    }

}