package com.example.week6.hw06.domain;

public class Product {

    private final Long id;
    private final String title;
    private final Integer price;
    private final Integer quantity;
    private final String category;
    private final Boolean onSale;

    public Product(Long id, String title, Integer price, Integer quantity, String category, Boolean onSale) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.onSale = onSale;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getOnSale() {
        return onSale;
    }
}