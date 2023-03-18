package com.example.deliveryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Cart {
    // TBD : private String cartId;
    // TBD : private String userId;
    private String postalCode;
    private List<Product> products;
}

