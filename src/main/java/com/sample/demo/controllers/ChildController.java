package com.sample.demo.controllers;

import com.sample.demo.domains.Child;
import com.sample.demo.dto.ChildDTO;
import com.sample.demo.services.ChildService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChildController {

    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }


    @GetMapping("/child")
    public ModelAndView list(@RequestParam(defaultValue = "1") String id){
        ModelAndView mav = new ModelAndView("child");
        mav.addObject("children", childService.list(Integer.parseInt(id)));
        return mav;
    }

    @GetMapping("/childList")
    public List<ChildDTO> list(){
        return childService.list(Integer.parseInt("1"));
    }
}
