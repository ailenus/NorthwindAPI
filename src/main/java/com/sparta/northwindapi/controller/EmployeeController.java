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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> getEmployeeById(@PathVariable int id){

        Optional<EmployeeDTO> optional = DAO.findById(id);
        ResponseEntity<String> result;

        if (optional.isPresent()){
            EmployeeDTO dto = optional.get();
            try {
                result = new ResponseEntity<>(objectMapper.writeValueAsString(dto), httpHeaders, HttpStatus.OK);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"Employee not found\"}",
                    httpHeaders, HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllEmployees() {

        List<Employee> list = DAO.findAll();
        List<String> result = new ArrayList<>();
        list.stream().forEach(employee -> {
            try {
                result.add(objectMapper.writeValueAsString(employee));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        return new ResponseEntity<>(result.toString(), httpHeaders, HttpStatus.OK);
    }

}