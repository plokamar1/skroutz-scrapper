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
    private URL link;

    @ManyToMany
    @JoinTable(name = "category_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public boolean addCategory(Category _category) {
        return categories.add(_category);
    }

    public boolean removeCategory(long _categoryId) {
        for (Iterator<Category> it = categories.iterator(); it.hasNext();) {
            Category c = it.next();
            if (c.getId() == _categoryId) {
                categories.remove(c);
                return true;
            }
        }
        return false;
    }
}
