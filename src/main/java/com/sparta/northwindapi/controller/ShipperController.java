package com.sparta.northwindapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dto.ShipperDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    DAO<ShipperDTO> dao;

    public ShipperController(DAO<ShipperDTO> dao) {
        this.dao = dao;
    }

    @GetMapping("/")
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
                            Welcome to the Shipper Sector of the API
                        </h1>
                        <br>
                        <h2>GET options:</h2>
                        <ul>
                            <li>To get a shipper by ID -> <code>/shipper/id/<i>shipper_id</i></code></li>
                            <li>To get all shippers -> <code>/shipper/all</code></li>
                        </ul>
                    </body>
                </html>
                """;
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ShipperDTO getById(@PathVariable int id) {
        Optional<ShipperDTO> result = dao.findById(id);
        System.out.printf("%s result for id: %s\n", result.isPresent()?"got":"no", id);
        if (result.isPresent()) return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ShipperDTO> getAll() {
        return dao.findAll();
    }

    //------------- Yannan's code below
    @GetMapping("/{id}/company_name")
    public ResponseEntity<String> getCompanyName(@PathVariable int id) {
        Optional<ShipperDTO> optional = dao.findById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "text/plain");
        if (optional.isPresent()) {
            ShipperDTO item = optional.get();
            result = new ResponseEntity<>(item.getCompanyName(), httpHeaders,
                    HttpStatus.OK);
        } else {
            result = new ResponseEntity<>("Shipper not found", httpHeaders,
                    HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("{id}/phone")
    public ResponseEntity<String> getPhone(@PathVariable int id) {
        Optional<ShipperDTO> optional = dao.findById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "text/plain");
        if (optional.isPresent()) {
            ShipperDTO item = optional.get();
            result = new ResponseEntity<>(item.getPhone(), httpHeaders,
                    HttpStatus.OK);
        } else {
            result = new ResponseEntity<>("Shipper not found", httpHeaders,
                    HttpStatus.OK);
        }
        return result;
    }

    @PatchMapping("/{id}/company_name/{newCompanyName}")
    public ResponseEntity<String> updateCompanyName(@PathVariable int id,
                                        @PathVariable String newCompanyName) {
        ShipperDTO item = new ShipperDTO(id, newCompanyName, null);
        return updateHelper(item);
    }

    @PatchMapping("{id}/phone/{newPhone}")
    public ResponseEntity<String> updatePhone(@PathVariable int id,
                                              @PathVariable String newPhone) {
        ShipperDTO item = new ShipperDTO(id, null, newPhone);
        return updateHelper(item);
    }

    private ResponseEntity<String> updateHelper(ShipperDTO item) {
        Optional<ShipperDTO> optional = dao.findById(dao.update(item));
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "application/json");
        if (optional.isPresent()) {
            item = optional.get();
            try {
                result = new ResponseEntity<>(
                        objectMapper.writeValueAsString(item), httpHeaders,
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

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> result;
        httpHeaders.add("content-type", "text/plain");
        if (dao.deleteById(id)) {
            result = new ResponseEntity<>("Deleted shipper " + id, httpHeaders,
                    HttpStatus.OK);
        } else {
            result = new ResponseEntity<>("Shipper not found", httpHeaders,
                    HttpStatus.OK);
        }
        return result;
    }
}