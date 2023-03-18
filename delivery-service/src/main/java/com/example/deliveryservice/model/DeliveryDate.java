package com.example.deliveryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDate {
    private String postalCode;
    private LocalDateTime deliveryDate;
    private boolean isGreenDelivery;

}