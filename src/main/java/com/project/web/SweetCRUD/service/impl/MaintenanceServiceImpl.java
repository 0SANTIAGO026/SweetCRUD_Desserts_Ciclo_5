package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.CategoryDto;
import com.project.web.SweetCRUD.dto.ProductCreateDto;
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
    CategoryRepository categoryRepository;

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
    public boolean removeFilm(ProductDTO productDTO) {
        Optional<Product> optional = productRepository.findById(productDTO.id());
        return optional.map(
                product -> {
                    productRepository.delete(product);
                    return true;
                }
        ).orElse(false);
    }
    
    @Override
    public List<CategoryDto> findAllCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        Iterable<Category> iterable = categoryRepository.findAll();
        iterable.forEach(category -> {
            categories.add(new CategoryDto(category.getId(), category.getName(), category.getDescription()));
        });
        return categories;
    }

    @Override
    public Boolean createProduct(ProductCreateDto productCreateDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(productCreateDto.categoryId());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            Product product = new Product();
            product.setName(productCreateDto.name());
            product.setPrice(productCreateDto.price());
            product.setStock(productCreateDto.stock());
            product.setCategory(category);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
