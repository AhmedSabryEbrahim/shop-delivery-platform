package com.example.deliveryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private String productId;
    private String name;
    private List<DayOfWeek> deliveryDays;
    private String productType;
    private int daysInAdvance;
}
