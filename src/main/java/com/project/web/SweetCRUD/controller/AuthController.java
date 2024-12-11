package com.project.web.SweetCRUD.controller;

import com.project.web.SweetCRUD.dto.UserAuthDto;
import com.project.web.SweetCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String authenticationUser(Model model) {
        model.addAttribute("user", new UserAuthDto("", ""));
        return "authenticationUser";
    }

    @PostMapping
    public String authentication(@ModelAttribute UserAuthDto userAuthDto) {
        if(userService.findByEmailAndPassword(userAuthDto.email(), userAuthDto.password()))
            return "redirect:/maintenance/start";
        else
            return "redirect:/auth?error";
    }
}
