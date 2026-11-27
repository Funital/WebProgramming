package com.example.week6.hw06.service;

import com.example.week6.hw06.domain.Product;
import com.example.week6.hw06.dto.ProductForm;
import com.example.week6.hw06.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void save(String title, Integer price, Integer quantity, String category, Boolean onSale) {
        Product product = new Product(
                title, price, quantity, category, onSale
        );

        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> search(String keyword) {
        return productRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException(
                                "해당 상품을 찾을 수 없습니다."
                        )
                );
    }

    @Transactional
    public void update(Long id, String title, Integer price, Integer quantity, String category, Boolean onSale){
        Product product = findById(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setOnSale(onSale);
    }

    public void delete(Long id){
        findById(id);
        productRepository.deleteById(id);
    }
}