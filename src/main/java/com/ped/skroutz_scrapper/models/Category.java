package com.ped.skroutz_scrapper.models;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

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
    private URL link;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

}
