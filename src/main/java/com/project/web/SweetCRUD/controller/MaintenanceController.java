package com.project.web.SweetCRUD.controller;


import com.project.web.SweetCRUD.dto.CategoryDto;
import com.project.web.SweetCRUD.dto.ProductCreateDto;
import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        maintenanceService.removeProduct(productDTO);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/update/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        ProductDTO product = maintenanceService.findProductById(id);
        model.addAttribute("product", product);

        List<CategoryDto> categories = maintenanceService.findAllCategories();
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

    @GetMapping("/create")
    public String create(Model model) {
        List<CategoryDto> categories = maintenanceService.findAllCategories();
        model.addAttribute("categories", categories);
        return "maintenance_create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductCreateDto productCreateDto, RedirectAttributes redirectAttributes) {
        boolean success = maintenanceService.createProduct(productCreateDto);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Postre creado con éxito");
            redirectAttributes.addFlashAttribute("messageType", "success");
            return "redirect:/maintenance/start";
        }
        redirectAttributes.addFlashAttribute("message", "Error al crear el postre");
        redirectAttributes.addFlashAttribute("messageType", "error");
        return "redirect:/maintenance/create";
    }

}
