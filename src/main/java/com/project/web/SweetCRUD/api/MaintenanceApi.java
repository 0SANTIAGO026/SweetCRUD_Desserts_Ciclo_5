package com.project.web.SweetCRUD.api;

import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.response.DetailsProductsResponse;
import com.project.web.SweetCRUD.response.FindProductsResponse;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maintenance-Api")
public class MaintenanceApi {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/allProducts")
    public FindProductsResponse finCar(){
        try {
            List<ProductDTO> cars = maintenanceService.findAllProduct();
            return new FindProductsResponse("01","",cars);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindProductsResponse("99","Service not found",null);
        }
    }

    @GetMapping("/details")
    public DetailsProductsResponse detailsCarId(@RequestParam(value ="id",defaultValue = "0") String id){
        try {
            if( Integer.parseInt(id) > 0){
                ProductDTO productDTO = maintenanceService.findProductById(Integer.parseInt(id));
                return new DetailsProductsResponse("01", "", productDTO);
            }else{
                return new DetailsProductsResponse("99", "Car not found",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DetailsProductsResponse("99","Service not found",null);
        }
    }
}
