package com.sda.controller;


import com.sda.model.User;
import com.sda.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CostumeController {

    private final OrderService orderService;

    public CostumeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/costume/{id}", produces = "application/json")
    public ModelAndView findAllCostumes(@PathVariable(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("costume");
        modelAndView.addObject("costume", orderService.getOne(id));
        return modelAndView;
    }

    @GetMapping("/costumes")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("costumes-bootstrap");
        modelAndView.addObject("costumes", orderService.findAll());
        return modelAndView;
    }

    @GetMapping("/rentForm")
    public String sendForm(User user) {
        return "rentForm";
    }

    @PostMapping("/rentForm")
    public String handleCostumeForm(@ModelAttribute User user) {
        return "thank-you";
    }
}

