package com.project.web.SweetCRUD.dto;

import java.util.Date;

public record SalesDto(

        Integer idSale,
        String userEmail,
        String productName,
        Date saleDate

) {
}
