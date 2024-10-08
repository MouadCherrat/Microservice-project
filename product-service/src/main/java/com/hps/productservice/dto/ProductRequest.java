package com.hps.productservice.dto;

import com.hps.productservice.entity.Sexe;

import java.math.BigDecimal;

public record ProductRequest(
        String name,
         String description,

         double availableQuantity,
         BigDecimal price,
         String imageUrl,
         Sexe sexe,
         Long brandId
) {
}
