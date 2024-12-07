package com.project.web.SweetCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profiles {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idProfile;
    private String profileName;

    @OneToMany(mappedBy = "profile")
    private List<Users> users;

}
