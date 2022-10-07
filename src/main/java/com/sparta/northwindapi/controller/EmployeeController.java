package com.sparta.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.northwindapi.dao.EmployeeDAO;
import com.sparta.northwindapi.dto.EmployeeDTO;
import com.sparta.northwindapi.dto.ShipperDTO;
import com.sparta.northwindapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDAO DAO;
    private ObjectMapper objectMapper = new ObjectMapper();
    private HttpHeaders httpHeaders = new HttpHeaders();

    public EmployeeController(EmployeeDAO dao){
        this.DAO = dao;
        objectMapper.registerModule(new JavaTimeModule());
        httpHeaders.add("content-type", "application/json");
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
                            Welcome to the Employee Sector of the API
                        </h1>
                    </body>
                </html>
                """;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeDTO getById(@PathVariable int id) {
        Optional<EmployeeDTO> result = DAO.findById(id);
        System.out.printf("%s result for id: %s\n", result.isPresent()?"got":"no", id);
        if (result.isPresent()) return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<EmployeeDTO> getAll() {
        return DAO.findAll();
    }

    @PatchMapping("{id}/{firstName}")
    public ResponseEntity<String> updateFirstName(@PathVariable int id, @PathVariable String firstName){

        ResponseEntity<String> result = null;
        Optional<EmployeeDTO> optional = DAO.findById(id);
        if (optional.isPresent()){
            EmployeeDTO item = optional.get();
            item.setFirstName(firstName);
            DAO.update(item);
            try {
                result = new ResponseEntity<>(
                        objectMapper.writeValueAsString(item), httpHeaders,
                        HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result =
                    new ResponseEntity<>("{\"message\": \"Employee not found\"}",
                            httpHeaders, HttpStatus.OK);
        }
        return result;
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        ResponseEntity<String> result;
        if (DAO.deleteById(id)) {
            result = new ResponseEntity<>("Deleted Employee " + id, httpHeaders,
                    HttpStatus.OK);
        } else {
            result = new ResponseEntity<>("Employee not found", httpHeaders,
                    HttpStatus.OK);
        }
        return result;
    }

}