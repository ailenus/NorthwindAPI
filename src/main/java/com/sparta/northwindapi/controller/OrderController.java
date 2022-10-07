package com.sparta.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dao.OrderDAO;
import com.sparta.northwindapi.dto.OrderDTO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

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
                            Welcome to the Order Sector of the API
                        </h1>
                    </body>
                </html>
                """;
    }

    private  final DAO<OrderDTO> dao;

    public OrderController(DAO<OrderDTO> dao) {
        this.dao = dao;
    }
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public OrderDTO getOrder(@PathVariable int id){

        Optional<OrderDTO> result = dao.findById(id);
        if (result.isPresent())
            return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAll()
    {
        return  dao.findAll();
    }


    //@PatchMapping("/")
}