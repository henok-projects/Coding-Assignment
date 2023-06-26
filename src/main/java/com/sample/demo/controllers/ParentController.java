package com.sample.demo.controllers;

import com.sample.demo.domains.Parent;
import com.sample.demo.services.ParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class ParentController {
    private ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/")
    public ModelAndView list(){

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("parents", parentService.list());
        return mav;
    }

    @GetMapping("/parentId")
    public Iterable<Parent> findAll() {
        return parentService.findAll();
    }
}
