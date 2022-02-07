package com.begaliev.month9onlineshop.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Table(name = "purchases")
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Size(min = 1, max = 128)
    @NotBlank
    @Column(length = 128)
    private String productName;

    @NotNull
    @PositiveOrZero
    @Column(length = 128)
    private float price;

    @PositiveOrZero
    @Column(length = 128)
    private float quantity;
}
