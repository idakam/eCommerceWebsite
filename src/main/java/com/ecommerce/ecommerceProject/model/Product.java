package com.ecommerce.ecommerceProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    private int quantity;
    private float price;

    private String brand;
    private String category;
    private String description;
    private String size;
    private String name;
    private String image;

    public Product(int quantity, float price, String description, String name, String brand, String category,
                   String image, Long id) {
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.image = image;
        this.id = id;
    }
}
