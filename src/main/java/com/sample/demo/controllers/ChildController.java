package com.sample.demo.controllers;

import com.sample.demo.domains.Child;
import com.sample.demo.services.ChildService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChildController {

    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/childList")
    public Iterable<Child> list(){
        return childService.list();
    }
}
