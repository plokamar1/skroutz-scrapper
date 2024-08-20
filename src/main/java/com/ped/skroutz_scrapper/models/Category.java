package com.ped.skroutz_scrapper.models;

import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
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
    private String platformIdentifier;

    @Column(nullable = false)
    private URL link;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public boolean addProduct(Product _product) {
        return products.add(_product);
    }

    public boolean removeProduct(long _productId) {
        for (Iterator<Product> it = products.iterator(); it.hasNext();) {
            Product p = it.next();
            if (p.getId() == _productId) {
                return products.remove(p);
            }
        }
        return false;
    }
}
