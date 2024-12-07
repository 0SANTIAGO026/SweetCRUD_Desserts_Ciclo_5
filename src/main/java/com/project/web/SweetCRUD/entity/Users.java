package com.project.web.SweetCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profiles profile;
}
