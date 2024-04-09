package com.example.trial2;

import java.util.Date;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private List<Integer> images; // assuming image resource IDs
    private Date dateAdded;
    private String category;
    private String description;
    private double discount;
    private String information;
    private int availableQuantity;

    // Constructor, getters, and setters


    public Product(String name, double price, List<Integer> images, Date dateAdded, String category, String description, double discount, String information, int availableQuantity) {
        this.name = name;
        this.price = price;
        this.images = images;
        this.dateAdded = dateAdded;
        this.category = category;
        this.description = description;
        this.discount = discount;
        this.information = information;
        this.availableQuantity = availableQuantity;
    }

    public Product() {

    }

    public Product(String s, String s1, String s2, String s3, int iphone14ProMax) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getImageResource() {
        return 0;
    }

    public int getQuantity() {
        return availableQuantity;
    }
}