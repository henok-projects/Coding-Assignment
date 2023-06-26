package com.sample.demo.controllers;

import com.sample.demo.domains.Child;
import com.sample.demo.dto.ChildDTO;
import com.sample.demo.services.ChildService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{id}")
    public List<ChildDTO> findById(@PathVariable int id){
        return childService.findChildById(id);
    }
}
