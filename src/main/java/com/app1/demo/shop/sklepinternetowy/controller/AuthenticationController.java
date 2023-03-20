package com.app1.demo.shop.sklepinternetowy.controller;

import com.app1.demo.shop.sklepinternetowy.exception.AuthenticationServiceException;
import com.app1.demo.shop.sklepinternetowy.request.RegisterRequest;
import com.app1.demo.shop.sklepinternetowy.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    private AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        //RegisterRequest registerRequest = new RegisterRequest();
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView createUser(@ModelAttribute("registerRequest") RegisterRequest request) {
        ModelAndView modelAndView = new ModelAndView("shop-page");
        modelAndView.addObject("request", request);
        try {
            service.createUser(request);
            modelAndView.addObject("message", "Konto utworzone, zapraszamy na zakupy!");
        } catch (AuthenticationServiceException e) {
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }
}
