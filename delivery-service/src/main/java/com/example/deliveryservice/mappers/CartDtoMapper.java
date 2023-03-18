package com.example.deliveryservice.mappers;

import com.example.deliveryservice.dto.CartDto;
import com.example.deliveryservice.model.Cart;

public class CartDtoMapper {
    public CartDto map(Cart cart) {
        return new CartDto(
                cart.getPostalCode(),
                cart.getProducts()
        );
    }

    public Cart map(CartDto cartDto){
        return new Cart(
                cartDto.getPostalCode(),
                cartDto.getProducts()
        );
    }
}
