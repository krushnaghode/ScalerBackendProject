package com.scaler.nov_myprojectmodule.service;

import com.scaler.nov_myprojectmodule.models.Product;
import java.util.List;

public interface ProductService {
    Product getProductById(Long id); // if not work  do this getProductId(Long Id){}
    List<Product> getAllProducts();
    Product createProduct(Long id, String title, String description, Double price, String imageUrl, String category );
    Product updateProduct(Long id, String title, String description, Double price, String imageUrl, String category );
    void deleteProduct(Long id);
}
