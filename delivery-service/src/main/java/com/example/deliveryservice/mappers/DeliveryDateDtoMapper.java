package com.example.deliveryservice.mappers;

import com.example.deliveryservice.dto.DeliveryDateDto;
import com.example.deliveryservice.model.DeliveryDate;

public class DeliveryDateDtoMapper {
    public DeliveryDateDto toDto(DeliveryDate deliveryDate) {
        return new DeliveryDateDto(
                deliveryDate.getPostalCode(),
                deliveryDate.getDeliveryDate(),
                deliveryDate.isGreenDelivery()
        );
    }


    public DeliveryDate fromDto(DeliveryDateDto deliveryDateDto){
        return new DeliveryDate(
                deliveryDateDto.getPostalCode(),
                deliveryDateDto.getDeliveryDate(),
                deliveryDateDto.isGreenDelivery()
        );
    }
}
