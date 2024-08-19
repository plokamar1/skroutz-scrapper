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
    void testEquals() {

    }

    @Test
    void testGetId() {

    }

    @Test
    void testGetPlatformIdentifier() {
        String platformIdentifier = product.getPlatformIdentifier();

        assertEquals(platformIdentifier, "platformIdentifier");
    }

    @Test
    void testGetPrice() {
        Double price = product.getPrice();

        assertEquals(price, 256.45);
    }

    @Test
    void testGetTitle() {
        String title = product.getTitle();

        assertEquals(title, "Huawei Mobile Phone");
    }

    @Test
    void testHashCode() {

    }

    @Test
    void testSetId() {

    }

    @Test
    void testSetPlatformIdentifier() {
        product.setPlatformIdentifier("aNewPlatformIdentifier");

        String platformIdentifier = product.getPlatformIdentifier();

        assertEquals(platformIdentifier, "aNewPlatformIdentifier");
    }

    @Test
    void testSetPrice() {
        product.setPrice(522.5);

        Double price = product.getPrice();

        assertEquals(price, 522.50);
    }

    @Test
    void testSetTitle() {
        product.setTitle("A new Title");

        String title = product.getTitle();

        assertEquals(title, "A new Title");
    }

    @Test
    void testToString() {
        String productToString = product.toString();

        assertThat(productToString).isInstanceOf(String.class);
    }

    @Test
    void testGetCategories() {
        Set<Category> categories = product.getCategories();

        assertThat(categories.size()).isEqualTo(1);
        assertThat(categories.iterator().next()).isInstanceOf(Category.class);
        assertThat(categories.iterator().next()).isEqualTo(category);
    }

    @Test
    void testGetLink() {
        URL productUrl = product.getLink();

        assertThat(productUrl.toString()).isEqualTo("https://localhost.com/product");
    }

    @Test
    void testSetCategories() throws MalformedURLException {
        URL url = new URL("https://test.com");
        Category newCategory = Category.builder()
                .link(url)
                .title("Another Test")
                .build();

        categories.add(newCategory);
        product.setCategories(categories);

        assertThat(product.getCategories().size()).isEqualTo(2);
        assertThat(product.getCategories().toArray()[1]).isEqualTo(newCategory);
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
