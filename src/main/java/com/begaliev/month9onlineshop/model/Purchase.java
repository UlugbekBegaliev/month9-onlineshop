package com.begaliev.month9onlineshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "purchases")
@Entity
public class Purchase {
}
