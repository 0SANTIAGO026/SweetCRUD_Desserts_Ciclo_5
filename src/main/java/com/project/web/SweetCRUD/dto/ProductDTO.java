package com.project.web.SweetCRUD.dto;

public record ProductDTO(Integer id,
                         String name,
                         Double price,
                         Integer stock,
                         String category) {
}
