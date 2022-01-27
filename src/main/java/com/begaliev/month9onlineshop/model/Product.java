package com.begaliev.month9onlineshop.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128)
    private String name;

    @Column(length = 300)
    private String description;

    @Column(length = 128)
    private String image;

    @Column(length = 128)
    private int quantity;

    @NotNull
    @Column(length = 128)
    private float price;

    @ManyToOne
    @JoinColumn(name = "productType_id")
    private ProductType productType;
}
