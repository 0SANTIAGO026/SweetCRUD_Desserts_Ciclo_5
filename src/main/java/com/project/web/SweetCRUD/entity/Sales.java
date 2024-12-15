package com.project.web.SweetCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSale;
    private String creditCardNumber;
    private Integer expirationMonth;
    private Integer expirationYear;
    private String cvv;
    private String cardholderName;
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name="id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_user")
    private Users users;

}
