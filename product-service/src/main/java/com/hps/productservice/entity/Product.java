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
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    //todo: add reference
    //todo: change id type to UUID
    //todo: add crud for categories
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;

}
