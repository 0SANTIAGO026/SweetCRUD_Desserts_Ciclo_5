package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.entity.Product;
import com.project.web.SweetCRUD.repository.ProductRepository;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAllProduct() {

        List<ProductDTO> products = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        iterable.forEach(product -> {
            ProductDTO productDto = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock(),
                    product.getCategory().getName());
            products.add(productDto);
        });
        return products;
    }
}
