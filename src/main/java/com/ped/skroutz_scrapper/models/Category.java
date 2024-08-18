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
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long platformIdentifier;

    @Column(nullable = false)
    private Link link;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = null;

}
