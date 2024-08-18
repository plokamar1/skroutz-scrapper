package com.ped.skroutz_scrapper.models;

import java.util.Set;

import com.github.dockerjava.api.model.Link;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String platformIdentifier;

    @Column(nullable = true)
    private double price;

    @Column(nullable = false)
    private Link link;

    @ManyToMany
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = null;
}
