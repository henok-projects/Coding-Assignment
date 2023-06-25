package com.sample.demo.controllers;

import com.sample.demo.domains.Parent;
import com.sample.demo.services.ParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ParentController {

    private ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parentList")
    public Iterable<Parent> list(){
        return parentService.list();
    }
}
