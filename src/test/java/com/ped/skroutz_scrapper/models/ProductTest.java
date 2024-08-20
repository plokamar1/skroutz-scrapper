package com.ped.skroutz_scrapper.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product;
    Category category;
    Set<Category> categories = new HashSet<>();

    @BeforeEach
    public void setup() throws MalformedURLException {
        URL categoryUrl = new URL("https://localhost.com");
        category = Category.builder()
                .title("A product Category")
                .link(categoryUrl)
                .build();

        categories.add(category);
        URL productUrl = new URL("https://localhost.com/product");
        product = Product.builder()
                .title("Huawei Mobile Phone")
                .price(256.45)
                .categories(categories)
                .link(productUrl)
                .platformIdentifier("platformIdentifier")
                .build();
    }

    @Test
    void testSetLink() throws MalformedURLException {
        URL newUrl = new URL("https://test.com/test");
        product.setLink(newUrl);

        assertThat(product.getLink()).isInstanceOf(URL.class);
        assertThat(product.getLink().toString()).isEqualTo(newUrl.toString());
    }

    @Test
    void testAddCategory() throws MalformedURLException {
        URL url = new URL("https://test.com");

        Category newCategory = Category.builder()
                .link(url)
                .title("Another Test")
                .build();

        assertThat(product.addCategory(newCategory)).isTrue();
        assertThat(product.getCategories().size()).isEqualTo(2);
    }

    @Test
    void testShouldNotAddCategory() {
        assertThat(product.addCategory(category)).isFalse();
        assertThat(product.getCategories().size()).isEqualTo(1);
    }

    @Test
    void testRemoveCategory() {
        assertThat(product.removeCategory(category.getId())).isTrue();
        assertThat(product.getCategories().size()).isEqualTo(0);
    }

    @Test
    void testShouldNotRemoveCategory() {
        long fakeId = 1231232;
        assertThat(product.removeCategory(fakeId)).isFalse();
        assertThat(product.getCategories().size()).isEqualTo(1);
    }
}
