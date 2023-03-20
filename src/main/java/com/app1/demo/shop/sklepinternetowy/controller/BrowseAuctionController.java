package com.app1.demo.shop.sklepinternetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrowseAuctionController {
    @GetMapping("browse-auction")
    public String getBrowseAuctionForm(){
        return "browse-auction-form";
    }
}
