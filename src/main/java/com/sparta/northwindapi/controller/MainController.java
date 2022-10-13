package com.sparta.northwindapi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController implements ErrorController {

    @RequestMapping("error")
    public String handleError() {
        return "error.html";
    }

}