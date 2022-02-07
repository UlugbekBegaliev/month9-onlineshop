package com.begaliev.month9onlineshop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Column(length = 128)
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
