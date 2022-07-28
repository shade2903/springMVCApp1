package com.haiduk.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message","Hello " + name + " " + surname);
        return "first/hello";

    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") Double a,
                             @RequestParam(value = "b") Double b,
                             @RequestParam(value = "action") String action,
                             Model model
                             ){
        Double result;
        switch (action){
            case "multiplication":
                result = a*b;
                break;
            case "addition":
                result  = a + b;
                break;
            case  "subtraction":

                result = a - b;
                break;
            case  "division":
                result = a/ b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("message","a: " + a + " action: " + action + " b " + b + " = " + result);
        
        return "first/calculator";
    }

    @GetMapping("goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
