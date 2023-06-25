package com.sample.demo.controllers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sample.demo.domains.Parent;
import com.sample.demo.services.ParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/api")api
public class ParentController {
    private ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/")
    public ModelAndView list(){
//        return parentService.list();

        ModelAndView mav = new ModelAndView("index");


        mav.addObject("parents", parentService.list());

        return mav;
    }
}
