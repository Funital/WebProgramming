package com.example.week6.hw06.service;

import com.example.week6.hw06.domain.Product;
import com.example.week6.hw06.dto.ProductForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long sequence = 1L;

    public void save(ProductForm productForm) {
        Product product = new Product(
                sequence++, productForm.getTitle(), productForm.getPrice(), productForm.getQuantity(), productForm.getCategory(), productForm.getOnSale()
        );

        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}