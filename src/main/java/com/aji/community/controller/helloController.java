package com.aji.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("/hello")
    public String print_hello(@RequestParam(name = "usrName") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}