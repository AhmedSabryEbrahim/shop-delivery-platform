package com.example.deliveryservice.dto;

import com.example.deliveryservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CartDto {
    private String postalCode;
    private List<Product> products;
}
