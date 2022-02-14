package com.begaliev.month9onlineshop.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Builder
@Table(name = "updates")
public class PasswordManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
}
