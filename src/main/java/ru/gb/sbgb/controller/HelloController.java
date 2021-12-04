package ru.gb.sbgb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping
    @ResponseBody
    public String helloMessage() {
        return "Hello spring boot!!!";
    }

    @GetMapping("/hello")
    public String helloMessageJsp(Model model) {
        model.addAttribute("msg", "Hello spring boot!!!");
        return "hello";
    }

}
