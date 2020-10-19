package com.personaltraining.storagemanagement.controller;

import com.personaltraining.storagemanagement.model.Product;
import com.personaltraining.storagemanagement.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TODO: Restreindre l'accès ensuite
@CrossOrigin("*")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/productList")
    public List<Product>getProductlist(){
        return productRepository.findAll();
    }

    @GetMapping("/product")
    public Optional<Product> getProductById(@RequestParam Long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestParam Long id){
        productRepository.deleteById(id);
    }
}
