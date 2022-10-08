package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/territory")
public class TerritoryController {

    private final DAO<TerritoryDTO> dao;

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
                        .center { text-align:center; }
                        </style>
                    </head>
                    <body>
                        <h1 class="center">
                            Welcome to the Territory Sector of the API
                        </h1>
                        <br>
                        <h2>GET options:</h2>
                        <ul>
                            <li>To get a territory by ID -> <code>/territory/id/<i>territory_id</i></code></li>
                            <li>To get all territories -> <code>/territory/all</code></li>
                        </ul>
                    </body>
                </html>
                """;
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TerritoryDTO getById(@PathVariable int id) {
        Optional<TerritoryDTO> result = dao.findById(id);
        if (result.isPresent()) return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<TerritoryDTO> getAll() {
        return dao.findAll();
    }

}