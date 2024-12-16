package com.project.web.SweetCRUD.dto;

import java.util.Date;

public record SalesDetailDto(
        Integer idUser,
        Integer id,
        String creditCardNumber,
        Integer expirationMonth,
        Integer expirationYear,
        String cvv,
        String cardholderName

) {

}
