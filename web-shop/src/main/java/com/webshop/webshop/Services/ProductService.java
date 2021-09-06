package com.webshop.webshop.Services;

import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Models.Product;
import com.webshop.webshop.Repositories.ProductRepository;
import com.webshop.webshop.Services.Interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public Optional<Product> getOneById(Integer Id) {
        return productRepository.findById(Id);
    }

    @Override
    public List<Product> findByCategory(Optional<Category> category) {
        return productRepository.findByCategory(category);
    }
}
