package com.scaler.nov_myprojectmodule.dto;

import com.scaler.nov_myprojectmodule.models.Category;
import com.scaler.nov_myprojectmodule.models.Product;

import java.util.ArrayList;
import java.util.List;


public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
//    private String image;


    // fakestore is sending above response from there database

    // this method will create new product and assign new values
    // depending upon what we're receiving from the  fakestore

    // in this below we are matching the field sent by fakestore and what we set in the models
    // mapping the values to my product
    public Product getProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        // Properly map the category field to a Category object
        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);
        return product;
    }

    public List<Product> getProducts(FakeStoreProductDto[] fakeStoreProductDto) {
            List<Product> ListOfProducts = new ArrayList<>();
            for (FakeStoreProductDto fakeStoreProductDto1 : fakeStoreProductDto) {
                ListOfProducts.add(fakeStoreProductDto1.getProduct());
            }

        return ListOfProducts;
    }

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", imageUrl='" + image + '\'' +
                '}';

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
}
