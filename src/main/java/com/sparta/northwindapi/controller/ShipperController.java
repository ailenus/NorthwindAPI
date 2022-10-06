package com.sparta.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.dao.ShipperDao;
import com.sparta.northwindapi.dto.ShipperDto;
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

    private final ShipperRepository REPOSITORY;
    private final ShipperDao DAO;

    public ShipperController(ShipperRepository repository, ShipperDao dao) {
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
    public ShipperDto updateCompanyName(@PathVariable int id,
                                        @PathVariable String newCompanyName) {
        ShipperDto dto = new ShipperDto(id, newCompanyName, null);
        dto = DAO.update(dto);
        return dto;
    }

    @PatchMapping("{id}/phone/{newPhone}")
    public ShipperDto updatePhone(@PathVariable int id,
                                  @PathVariable String newPhone) {
        ShipperDto dto = new ShipperDto(id, null, newPhone);
        dto = DAO.update(dto);
        return dto;
    }

}
