package com.hps.productservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo: change id type to UUID
    private String description;
    private String reference;
    private String name;
    private double availableQuantity;
    private BigDecimal price;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
