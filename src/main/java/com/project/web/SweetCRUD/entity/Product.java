package com.project.web.SweetCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Double price;
    public Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    @OneToMany(mappedBy= "product")
    private List<Sales> sales;
}
