package com.webApplication.ecom_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webApplication.ecom_project.model.Product;
import com.webApplication.ecom_project.repository.productRepository;

@Service
public class ProductService {

    @Autowired
    private productRepository repository;

    public List<Product> getallProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product addProduct(Product product ,MultipartFile imageFile) {
        try {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
            return repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) {
        try {
            product.setImageData(imageFile.getBytes());
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            return repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    public List<Product> SearchProduct(String keyword) {
        return repository.SearchProduct(keyword);
    }
}
