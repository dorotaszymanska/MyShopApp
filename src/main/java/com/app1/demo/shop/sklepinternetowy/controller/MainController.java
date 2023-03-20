package com.app1.demo.shop.sklepinternetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(path = "/shop",method = RequestMethod.GET)
    public ModelAndView getAuctionPage(){
        return new ModelAndView("shop-page");
    }
}
