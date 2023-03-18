package com.example.deliveryservice.mappers;

import com.example.deliveryservice.dto.ProductDto;
import com.example.deliveryservice.model.Product;

public class ProductDtoMapper {
    public ProductDto toDto(Product product) {
        return new ProductDto(product.getProductId(),
                product.getName(),
                product.getDeliveryDays(),
                product.getProductType(),
                product.getDaysInAdvance()
        );
    }

    Product fromDto(ProductDto productDto){
        return new Product(productDto.getProductId(),
                productDto.getName(),
                productDto.getDeliveryDays(),
                productDto.getProductType(),
                productDto.getDaysInAdvance()
        );

    }
}
