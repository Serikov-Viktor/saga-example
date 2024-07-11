package com.serikov.inventory.entity;

import com.serikov.enums.ProductType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Integer id;
    @Column(name = "description")
    String description;
    @Column(name = "weight")
    Double weight;
    @Column(name = "type")
    ProductType type;
}
