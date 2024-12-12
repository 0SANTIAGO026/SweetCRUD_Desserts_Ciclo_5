package com.project.web.SweetCRUD.controller;


import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        ProductDTO productDTO= maintenanceService.findProductById(id);
        maintenanceService.removeFilm(productDTO);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "authenticationUser";
    }

}
