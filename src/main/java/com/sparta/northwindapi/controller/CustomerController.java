package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.entity.Customer;
import com.sparta.northwindapi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping({"","/"})
    public String basic() {
        return """
                <!DOCTYPE html>
                <html>
                    <head>
                        <title>Northwind API</title>
                        <link rel="icon" type="image/x-icon" href="https://i.pinimg.com/originals/03/ed/de/03edde789384ab169b248e0b37c96d47.jpg">
                        <style>
                        .right { text-align:right; }
                        .center { text-align:center; }
                        </style>
                    </head>
                    <body>
                        <h1 class="center">
                            Welcome to the Customer Sector of the API
                        </h1>
                    </body>
                </html>
                """;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
    }

    @GetMapping("/all")
    public List<Customer> getAllActors() {
    }
}
