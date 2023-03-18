package com.example.deliveryservice.controller;

import com.example.deliveryservice.dto.CartDto;
import com.example.deliveryservice.model.Cart;
import com.example.deliveryservice.model.DeliveryDate;
import com.example.deliveryservice.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@CrossOrigin("*")
@Slf4j
public class CartController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("")
    public ResponseEntity<List<DeliveryDate>> createCart(@RequestBody Cart cart) {
        log.info("cart : {}", cart);
        return new ResponseEntity<>(deliveryService.getAvailableDeliveryDates(cart), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}