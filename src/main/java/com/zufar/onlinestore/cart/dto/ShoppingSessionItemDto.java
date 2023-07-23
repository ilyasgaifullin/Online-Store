package com.zufar.onlinestore.cart.dto;

import com.zufar.onlinestore.cart.entity.ShoppingSession;
import com.zufar.onlinestore.product.dto.ProductInfoFullDto;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ShoppingSessionItemDto(

        @NotNull(message = "Id is the mandatory attribute")
        UUID id,

        @NotNull(message = "ShoppingSession is the mandatory attribute")
        ShoppingSession shoppingSession,

        @NotNull(message = "ProductInfo is the mandatory attribute")
        ProductInfoFullDto productInfo,

        @NotNull(message = "ProductsQuantity is the mandatory attribute")
        Integer productsQuantity
) {
}