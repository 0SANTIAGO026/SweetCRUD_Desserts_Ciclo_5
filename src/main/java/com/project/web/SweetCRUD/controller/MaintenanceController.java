package com.project.web.SweetCRUD.controller;

import com.project.web.SweetCRUD.dto.DessertsDto;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<DessertsDto> desserts = maintenanceService.findAllDesserts();
        model.addAttribute("desserts", desserts);
        return "maintenance";
    }

        @GetMapping("/user")
    public String user(Model model) {

        return "authenticationUser";
    }

}
