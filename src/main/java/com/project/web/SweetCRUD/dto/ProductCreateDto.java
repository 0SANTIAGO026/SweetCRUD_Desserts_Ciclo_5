package com.project.web.SweetCRUD.dto;

public record ProductCreateDto(
                               String name,
                               Double price,
                               Integer stock,
                               Integer categoryId) {
}