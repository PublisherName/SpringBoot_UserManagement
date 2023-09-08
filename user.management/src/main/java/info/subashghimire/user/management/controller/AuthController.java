package info.subashghimire.user.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    public AuthController(){};

    @GetMapping("/")
    public String root(Model model){
        return "index";
    }

    @GetMapping("/index")
    public String home(Model model){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        return "login/register";
    }

    @PostMapping("/register/save")
    public String registration(){
        return "login/register";
    }

    @GetMapping("/forgot")
    public String forgotPassword(Model model){
        return "login/forgotPassword";
    }

    @GetMapping("dashboard/users")
    public String users(Model model){
        return "users";
    }
}
