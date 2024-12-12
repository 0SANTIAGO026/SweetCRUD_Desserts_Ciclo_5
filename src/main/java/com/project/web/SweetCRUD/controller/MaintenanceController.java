package com.project.web.SweetCRUD.controller;


import com.project.web.SweetCRUD.dto.CategoryDTO;
import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.entity.Product;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
        List<ProductDTO> products = maintenanceService.findAllProduct();
        model.addAttribute("products", products);
        return "maintenance";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Integer id, Model model) {
        System.out.println("Eliminando " + id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/update/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        ProductDTO product = maintenanceService.findProductById(id);
        model.addAttribute("product", product);

        List<CategoryDTO> categories = maintenanceService.findAllCategories();
        model.addAttribute("categories", categories);

        return "updateProduct";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute ProductDTO productDTO) {
        // Actualizar el producto en la base de datos
        maintenanceService.updateProduct(productDTO);
        return "redirect:/maintenance/start"; // Redirigir al inicio
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "authenticationUser";
    }

}
