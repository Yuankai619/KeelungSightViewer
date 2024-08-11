package com.yuankai.keelungsightviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
