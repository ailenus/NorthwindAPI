package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.ShipperDAO;
import com.sparta.northwindapi.dto.ShipperDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.entity.Shipper;
import com.sparta.northwindapi.repo.ShipperRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
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
                            Welcome to the Shipper Sector of the API
                        </h1>
                    </body>
                </html>
                """;
    }

    private final ShipperRepository REPOSITORY;
    private final ShipperDAO DAO;

    public ShipperController(ShipperRepository repository, ShipperDAO dao) {
        this.REPOSITORY = repository;
        this.DAO = dao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable int id) {
        Optional<Shipper> optionalShipper = REPOSITORY.findById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "application/json");
        if (optionalShipper.isPresent()) {
            Shipper shipper = optionalShipper.get();
            try {
                result = new ResponseEntity<>(
                        objectMapper.writeValueAsString(shipper), httpHeaders,
                        HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result =
                    new ResponseEntity<>("{\"message\": \"Shipper not found\"}",
                            httpHeaders, HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("/{id}/company_name")
    public ResponseEntity<String> getCompanyName(@PathVariable int id) {
        Optional<Shipper> optionalShipper = REPOSITORY.findById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "text/plain");
        if (optionalShipper.isPresent()) {
            Shipper shipper = optionalShipper.get();
            try {
                result = new ResponseEntity<>(objectMapper.writeValueAsString(
                        shipper.getCompanyName()), httpHeaders, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result =
                    new ResponseEntity<>("message: Shipper not found",
                            httpHeaders, HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("{id}/phone")
    public ResponseEntity<String> getPhone(@PathVariable int id) {
        Optional<Shipper> optionalShipper = REPOSITORY.findById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "text/plain");
        if (optionalShipper.isPresent()) {
            Shipper shipper = optionalShipper.get();
            try {
                result = new ResponseEntity<>(
                        objectMapper.writeValueAsString(shipper.getPhone()),
                        httpHeaders, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("message: Shipper not found",
                    httpHeaders, HttpStatus.OK);
        }
        return result;
    }

    @PatchMapping("/{id}/company_name/{newCompanyName}")
    public ShipperDTO updateCompanyName(@PathVariable int id,
                                        @PathVariable String newCompanyName) {
        ShipperDTO dto = new ShipperDTO(id, newCompanyName, null);
        dto = DAO.update(dto);
        return dto;
    }

    @PatchMapping("{id}/phone/{newPhone}")
    public ShipperDTO updatePhone(@PathVariable int id,
                                  @PathVariable String newPhone) {
        ShipperDTO dto = new ShipperDTO(id, null, newPhone);
        dto = DAO.update(dto);
        return dto;
    }

}