package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.ProductDTO;

import java.util.List;

public interface MaintenanceService {

    List<ProductDTO> findAllProduct();
    ProductDTO findProductById(int id);

    boolean removeFilm(ProductDTO productDTO);
}
