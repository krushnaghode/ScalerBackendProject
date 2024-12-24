package com.scaler.nov_myprojectmodule.controller;

import com.scaler.nov_myprojectmodule.models.Product;
import com.scaler.nov_myprojectmodule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
public class ProductController {
    // CRUD Api's around the product using ProductService Interface
    // for the product
    // 1. create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    // tied the productService and ProductController

    private ProductService productService; // this is creating relation between ProductService and ProductController
    // private is modifier
    // ProductService is an interface, or we can say class
    // productService is an object/instance of ProductService interface
    @Autowired
    // spring is injecting the dependencies here
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // this will help the creating the project
    // @RequestMapping(value = "/products ", method = RequestMethod.POST)
    @PostMapping("/products") //  same doing as @RequestMapping  annotations
    public Product createProduct(@RequestBody Product  product) {
        System.out.println("creating  product with imageUrl"+product.getImageUrl());
        Product p= productService.createProduct(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getCategory().getTitle());

        System.out.println("Product created successfully");
        return p;

    }
    // this will help to getting the product details
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("Starting the api here");
        Product p= productService.getProductById(id);
        System.out.println("Ending the api here");
        return p;
    }

    @GetMapping("/getallproducts")
    public List<Product> getAllProducts() {
        System.out.println("Fetching all products...");
        List<Product> products = productService.getAllProducts();
        return products;
    }

    // this will help to getting the product details
    @PutMapping("/updateproduct/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        System.out.println("Updating product with ID: " + id);
        Product p =productService.updateProduct(id,
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getCategory().getTitle());
        System.out.println("Product updated successfully with ID:" + id);
        return p;

    }
    // this will help to getting the product details
    @DeleteMapping("/deleteproduct/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        System.out.println("Deleting product with ID: " + id);
        Product p = productService.getProductById(id);
        // Get the product before deleting as the FKSPS has a void return type and we need to return the instance of the product
        productService.deleteProduct(id);
        System.out.println("Product deleted successfully with ID:" + id);
        return p;
    }
}
