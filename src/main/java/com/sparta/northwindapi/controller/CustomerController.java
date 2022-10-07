package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.CustomerDAO;
import com.sparta.northwindapi.dto.CustomerDTO;
import com.sparta.northwindapi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerRepository custRepo;

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
    public CustomerDTO updateCustomerById(@PathVariable int id, @PathVariable String companyName) {
        CustomerDTO customerDTO = new CustomerDTO(id, companyName, null, null, null, null, null, null, null, null, null);
        customerDTO = customerDAO.update(customerDTO);
        return customerDTO;
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomerDTO getById(@PathVariable int id) {
        Optional<CustomerDTO> result = customerDAO.findById(id);
        System.out.printf("%s result for id: %s\n", result.isPresent()?"got":"no", id);
        if (result.isPresent()) return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


}
