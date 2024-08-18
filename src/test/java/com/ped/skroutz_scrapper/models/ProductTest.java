package com.ped.skroutz_scrapper.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product product;

    @BeforeEach
    public void setup() {

        product = Product.builder()
                .title("Huawei Mobile Phone")
                .price(256.45)
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

        assertThat(platformIdentifier).isAlphanumeric();
        assertEquals(platformIdentifier, "platformIdentifier");
    }

    @Test
    void testGetPrice() {
        Double price = product.getPrice();

        assertThat(price).isInstanceOf(Double.class);
        assertEquals(price, 256.45);
    }

    @Test
    void testGetTitle() {
        String title = product.getTitle();

        assertThat(title).isInstanceOf(String.class);
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

        assertThat(platformIdentifier).isInstanceOf(String.class);
        assertEquals(platformIdentifier, "aNewPlatformIdentifier");
    }

    @Test
    void testSetPrice() {
        product.setPrice(522.5);

        Double price = product.getPrice();

        assertThat(price).isInstanceOf(Double.class);
        assertEquals(price, 522.50);
    }

    @Test
    void testSetTitle() {
        product.setTitle("A new Title");

        String title = product.getTitle();

        assertThat(title).isInstanceOf(String.class);
        assertEquals(title, "A new Title");
    }

    @Test
    void testToString() {
        String productToString = product.toString();

        assertThat(productToString).isInstanceOf(String.class);
    }
}
