package com.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DeliveryDateDto {
    private String postalCode;
    private LocalDateTime deliveryDate;
    private boolean isGreenDelivery;

}
