package com.project.web.SweetCRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desserts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDessert;
    private String dessertName;
    private String dessertType;
    private String description;
    private String timePreparation;
    private double price;

}
