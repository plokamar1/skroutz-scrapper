package com.ped.skroutz_scrapper.models;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    Product product;
    Category category;
    Set<Product> products = new HashSet<>();

    @BeforeEach
    public void setup() throws MalformedURLException {
        URL productUrl = new URL("https://localhost.com/product");

        product = Product.builder()
                .title("Huawei Mobile Phone")
                .price(256.45)
                .link(productUrl)
                .platformIdentifier("platformIdentifier")
                .build();

        URL categoryUrl = new URL("https://localhost.com");
        products.add(product);

        category = Category.builder()
                .link(categoryUrl)
                .platformIdentifier("12312312")
                .title("Test Category Title")
                .products(products)
                .build();

    }

    @Test
    void testAddProduct() {
        Product newProduct = Product.builder()
                .title("TestProduct")
                .price(245.22)
                .platformIdentifier("test_identifier")
                .build();

        assertThat(category.addProduct(newProduct)).isTrue();
        assertThat(category.getProducts().size()).isEqualTo(2);
    }

    @Test
    void testShouldNotAddProduct() {
        assertThat(category.addProduct(product)).isFalse();
        assertThat(category.getProducts().size()).isEqualTo(1);
    }

    @Test
    void testRemoveProduct() {
        assertThat(category.removeProduct(product.getId())).isTrue();
        assertThat(category.getProducts().size()).isEqualTo(0);
    }

    @Test
    void testShouldNotRemoveProduct() {
        long fakeId = 12312312;
        assertThat(category.removeProduct(fakeId)).isFalse();
        assertThat(category.getProducts().size()).isEqualTo(1);
    }
}
