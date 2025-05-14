package com.data.session07.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private String image;

    public Product(Long id, String name, Double price, Integer stock, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.image = image;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Integer getStock() { return stock; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
}
