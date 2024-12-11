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

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new UserAuthDto("", "", ""));
        return "authenticationUser";
    }

    @PostMapping("/login")
    public String loginPage(@ModelAttribute UserAuthDto userAuthDto) {
        if(userService.findByEmailAndPassword(userAuthDto.email(), userAuthDto.password1()))
            return "redirect:/maintenance/start";
        else
            return "redirect:/auth/login?error";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserAuthDto("", "", ""));
        return "registerUser";
    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute UserAuthDto userAuthDto) {
        if(!userAuthDto.password1().equals(userAuthDto.password2()))
            return "redirect:/auth/register?errorPass";
        else {
            boolean result = userService.registerUser(userAuthDto);
            if(result)
                return "redirect:/auth/login?success";
            else
                return "redirect:/auth/register?errorEmail";
        }
    }
}
