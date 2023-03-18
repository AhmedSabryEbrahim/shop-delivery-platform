package com.example.deliveryservice;

import com.example.deliveryservice.model.Cart;
import com.example.deliveryservice.model.Product;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class TestUtil {
    public static final List<Product> PRODUCT_LIST = Arrays.asList(
            new Product("1", "Product 1", Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY), "normal", 2),
            new Product("2", "Product 2", Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY), "external", 5),
            new Product("3", "Product 3", List.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY), "temporary", 1)
    );

    public static final Cart CART = new Cart("32211", PRODUCT_LIST);
}
