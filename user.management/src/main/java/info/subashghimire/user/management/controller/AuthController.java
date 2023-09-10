package info.subashghimire.user.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.subashghimire.user.management.service.UserService;
import info.subashghimire.user.management.entity.User;
import info.subashghimire.user.management.dto.UserDto;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String root(Model model) {
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
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "login/register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result,Model model)
    {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null,
                    "Passwords do not match");
            result.rejectValue("password", null,
                    "Passwords do not match");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "login/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success=true";
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
