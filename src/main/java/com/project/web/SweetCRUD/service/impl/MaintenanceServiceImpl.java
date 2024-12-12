package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.CategoryDTO;
import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.entity.Category;
import com.project.web.SweetCRUD.entity.Product;
import com.project.web.SweetCRUD.repository.CategoryRepository;
import com.project.web.SweetCRUD.repository.ProductRepository;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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

    @Override
    public ProductDTO findProductById(int id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock(),
                    product.getCategory().getName());
        }else{
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Boolean updateProduct(ProductDTO productDTO) {
        Optional<Product> productOpt = productRepository.findById(productDTO.id());
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setName(productDTO.name());
            product.setPrice(productDTO.price());
            product.setStock(productDTO.stock());
            Category category = categoryRepository.findByName(productDTO.category())
                    .orElseThrow(() -> new NoSuchElementException("Category not found"));
            product.setCategory(category);
            productRepository.save(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();
        Iterable<Category> iterable = categoryRepository.findAll();
        iterable.forEach(category -> {
            categories.add(new CategoryDTO(category.getId(), category.getName(), category.getDescription()));
        });
        return categories;
    }
}
