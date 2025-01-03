package com.scaler.nov_myprojectmodule.service;

import com.scaler.nov_myprojectmodule.dto.FakeStoreProductDto;
import com.scaler.nov_myprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.nov_myprojectmodule.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService {

    // inside this fakestore class will be implement third party service
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        System.out.println("Inside the fakestore product service");
        FakeStoreProductDto fakeStoreProductDto =
        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
//        System.out.println(fakeStoreProductDto.toString());
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("No product found with id: " + id);
        }
        return  fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("Inside the getAllProducts AP product service");
        FakeStoreProductDto[] fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        return  new FakeStoreProductDto().getProducts(fakeStoreProductDto);
    }


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, String category ) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto  response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class);
        System.out.println(fakeStoreProductDto.toString());
        return response.getProduct();
    }

    @Override
    public Product updateProduct(Long id, String title, String description, Double price, String imageUrl, String category) {
        System.out.println("updating the product with id: " + id);
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);
        restTemplate.put("https://fakestoreapi.com/products/"+id, fakeStoreProductDto);
        System.out.println("now the product is updated with id: " + id);
        return fakeStoreProductDto.getProduct();
    }

    @Override
    public void deleteProduct(Long id) {
        System.out.println("deleting the product with id: " + id);
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        System.out.println("now the product is deleted with id: " + id);

    }


}
