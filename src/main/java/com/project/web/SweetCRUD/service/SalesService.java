package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.SalesDetailDto;
import com.project.web.SweetCRUD.dto.SalesDto;


import java.util.List;
import java.util.Optional;


public interface SalesService {
    List<SalesDto> getAllSales() throws Exception;
    boolean addSale(SalesDetailDto salesDetailDto, String cvv) throws Exception;
}
