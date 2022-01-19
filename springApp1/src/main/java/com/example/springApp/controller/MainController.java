package com.example.springApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class MainController {

    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String greeting(Model model){
        LOGGER.log(Level.INFO, "Greeting page visited");
        return "greeting";
    }
}