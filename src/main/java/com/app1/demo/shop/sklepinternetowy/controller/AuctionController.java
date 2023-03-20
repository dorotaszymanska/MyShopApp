package com.app1.demo.shop.sklepinternetowy.controller;


import com.app1.demo.shop.sklepinternetowy.exception.AuctionServiceException;
import com.app1.demo.shop.sklepinternetowy.request.AuctionCreationRequest;
import com.app1.demo.shop.sklepinternetowy.service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuctionController {
    private AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @RequestMapping(path = "/add-auction", method = RequestMethod.GET)
    public ModelAndView getAuctionForm() {
        return new ModelAndView("new-auction-form");
    }

    @PostMapping("/add-auction")
    public String createPlanet(@RequestParam String name,
                               @RequestParam double price,
                               @RequestParam int amount,
                               Model model) {
        try {
            auctionService.createAuction(new AuctionCreationRequest(name, price, amount));
            model.addAttribute("message", "Dodano aukcję o nazwie: " + name);
        } catch (AuctionServiceException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "shop-page";
    }
}
