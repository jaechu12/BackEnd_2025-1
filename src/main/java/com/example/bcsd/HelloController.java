package com.example.bcsd;

import org.apache.catalina.util.Introspection;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class HelloController {

    @GetMapping("/introduce")
    public String introduceName(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name==null){
            return "hello.html";
        }
        model.addAttribute("name", name);
        return "hello2.html";
    }



}
