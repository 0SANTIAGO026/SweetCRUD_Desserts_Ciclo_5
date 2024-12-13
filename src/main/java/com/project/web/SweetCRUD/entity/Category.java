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
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String description;

    @OneToMany(mappedBy = "category")
    public List<Product> products;

}
