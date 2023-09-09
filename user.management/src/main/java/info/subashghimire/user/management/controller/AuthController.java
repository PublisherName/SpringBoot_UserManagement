package info.subashghimire.user.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    public AuthController(){};

    @GetMapping("/")
    public String root(Model model){
        return "redirect:login";
    }

    @GetMapping("/index")
    public String home(Model model){
        return "redirect: login";
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
        return "login/forgot_password";
    }

    @PostMapping("/forgot/process")
    public String processForgotPassword(Model model){
        return "login/forgot_password";
    }

    @GetMapping("/users")
    public String users(Model model){
        return "dashboard/users";
    }

    @RequestMapping("/blank")
    public String blank(Model model){
        return "dashboard/blank";
    }
}
