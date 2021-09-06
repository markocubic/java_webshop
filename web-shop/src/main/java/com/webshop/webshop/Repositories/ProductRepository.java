package com.webshop.webshop.Repositories;

import com.webshop.webshop.Models.Category;
import com.webshop.webshop.Models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategory(Optional<Category> category);
}
