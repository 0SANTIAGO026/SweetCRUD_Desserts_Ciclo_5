package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.CategoryDTO;
import com.project.web.SweetCRUD.dto.ProductDTO;

import java.util.List;

public interface MaintenanceService {

    List<ProductDTO> findAllProduct();
    ProductDTO findProductById(int id);
    Boolean updateProduct(ProductDTO productDTO);
    List<CategoryDTO> findAllCategories();

}
