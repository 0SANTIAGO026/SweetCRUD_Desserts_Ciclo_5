package com.project.web.SweetCRUD.api;
import com.project.web.SweetCRUD.response.AddSalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.web.SweetCRUD.dto.SalesDetailDto;
import com.project.web.SweetCRUD.dto.SalesDto;
import com.project.web.SweetCRUD.response.FindSalesResponse;
import com.project.web.SweetCRUD.service.SalesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesApi {

    @Autowired
    SalesService salesService;

    @GetMapping("/all")
    public FindSalesResponse findSales() {
        try {
            List<SalesDto> sales = salesService.getAllSales();
            if (!sales.isEmpty())
                return new FindSalesResponse("01", "", sales);
            else
                return new FindSalesResponse("03", "Sales list is not found", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new FindSalesResponse("99", "Service not found", null);
        }
    }


    @PostMapping("/add")
    public AddSalesResponse addSales(@RequestBody SalesDetailDto salesDetailDto,@RequestParam String cvv) {

        try {
            if (salesService.addSale(salesDetailDto,cvv)) {
                return new AddSalesResponse("01", "");
            }else{
                return new AddSalesResponse("02", "Product or User do not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AddSalesResponse("99", "Service not found");
        }
    }


}
