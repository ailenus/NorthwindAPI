package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dao.ShipperDAO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/territory")
public class TerritoryController {

    DAO<TerritoryDTO> dao;

    public TerritoryController(DAO<TerritoryDTO> dao) {
        this.dao = dao;
    }

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
                            Welcome to the Territory Sector of the API
                        </h1>
                    </body>
                </html>
                """;
    }

    @GetMapping("/run")
    public String run() {
        dao.findAll();
        return String.format("", "");
    }
}