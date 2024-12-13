package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.CategoryDto;
import com.project.web.SweetCRUD.dto.ProductCreateDto;
import com.project.web.SweetCRUD.dto.ProductDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface MaintenanceService {

    @Cacheable(value = "products")

    List<ProductDTO> findAllProduct();
  
    ProductDTO findProductById(int id);

    boolean removeFilm(ProductDTO productDTO);
  
    @CacheEvict(value = "products", allEntries = true)
    Boolean createProduct(ProductCreateDto productCreateDto);

    @Cacheable(value = "categories")
    List<CategoryDto> findAllCategories();r
}
