package com.example.productservice;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "productname")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

}