package com.begaliev.month9onlineshop.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 128)
    @Column(length = 128)
    private String productName;

    @PositiveOrZero
    @Column(length = 128)
    private float quantity;

    @NotNull
    @PositiveOrZero
    @Column(length = 128)
    private float price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
