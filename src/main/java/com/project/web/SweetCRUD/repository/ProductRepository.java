package com.project.web.SweetCRUD.repository;

import com.project.web.SweetCRUD.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
