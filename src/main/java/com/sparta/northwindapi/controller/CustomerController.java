package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.CustomerDAO;
import com.sparta.northwindapi.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

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

    @PatchMapping("id/{id}/name/{companyName}")
    public CustomerDTO updateCustomerById(@PathVariable String id, @PathVariable String companyName) {
        CustomerDTO customerDTO = new CustomerDTO(id, companyName, null, null, null, null, null, null, null, null, null);
        customerDTO = customerDAO.update(customerDTO);
        return customerDTO;
    }

    @GetMapping("/id/{id}")
    public CustomerDTO getCustomerById(@PathVariable String id) {
        CustomerDTO customerDTO = customerDAO.findById(id);
        return customerDTO;
    }



}
