package com.sparta.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.entity.Shipper;
import com.sparta.northwindapi.repo.ShipperRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    private final ShipperRepository REPOSITORY;

    public ShipperController(ShipperRepository repository) {
        this.REPOSITORY = repository;
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

}
