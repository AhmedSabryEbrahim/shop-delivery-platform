package com.example.deliveryservice;

import com.example.deliveryservice.model.Cart;
import com.example.deliveryservice.model.DeliveryDate;
import com.example.deliveryservice.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeliveryServiceTest {


    private DeliveryService deliveryService;
    private Cart cart;

    @BeforeEach
    public void setup() {
        this.deliveryService = new DeliveryService();
        this.cart = TestUtil.CART;
    }

    @Test
    public void testInvalidWeekendDeliveryDate() {
        final List<DeliveryDate> deliveryDates = deliveryService.getAvailableDeliveryDates(cart);
        assertNotNull(deliveryDates);
    }
}
