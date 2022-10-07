package com.sparta.northwindapi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController implements ErrorController {
    @GetMapping("")
    public String basic() {
        return """
                <!DOCTYPE html>
                <html>
                    <head>
                        <title>Northwind API</title>
                        <link rel="icon" type="image/x-icon" href="https://i.pinimg.com/originals/03/ed/de/03edde789384ab169b248e0b37c96d47.jpg">
                        <style>.center { text-align:center; }</style>
                    </head>
                    <body>
                        <h1 class="center">Welcome to the Northwind API.</h1>
                        <br>
                        <h2>API list:</h2>
                        <ul>
                            <li><a href="customer">Customer API</a></li>
                            <li><a href="employee">Employee API</a></li>
                            <li><a href="order">Order API</a></li>
                            <li><a href="shipper">Shipper API</a></li>
                            <li><a href="territory">Territory API</a></li>
                        </ul>
                    </body>
                </html>
                """;
    }

    @RequestMapping("error")
    public String handleError() {
        return """
                <!DOCTYPE html>
                <html>
                    <head>
                        <title>Northwind API</title>
                        <link rel="icon" type="image/x-icon" href="https://i.pinimg.com/originals/03/ed/de/03edde789384ab169b248e0b37c96d47.jpg">
                        <style>.center { text-align:center; }</style>
                    </head>
                    <body>
                        <h1 class="center">404</h1>
                        <h2 class="center">There has been an error.</h2>
                        <br>
                        <h2><a href="/">Go home</a></h2>
                    </body>
                </html>
                """;
    }
}