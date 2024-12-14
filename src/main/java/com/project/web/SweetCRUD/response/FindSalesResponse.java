package com.project.web.SweetCRUD.response;
import com.project.web.SweetCRUD.dto.SalesDto;

public record FindSalesResponse (
        String code,
        String error,
        Iterable<SalesDto> sales

){

}
