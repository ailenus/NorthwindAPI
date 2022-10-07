package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final DAO<EmployeeDTO> dao;

    public EmployeeController(DAO<EmployeeDTO> dao){
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
                            Welcome to the Employee Sector of the API
                        </h1>
                        <br>
                        <h2>GET options:</h2>
                        <ul>
                            <li>To get a employee by ID -> <code>/employee/id/<i>employee_id</i></code></li>
                            <li>To get all employees -> <code>/employee/all</code></li>
                        </ul>
                    </body>
                </html>
                """;
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeDTO getById(@PathVariable int id) {
        Optional<EmployeeDTO> result = dao.findById(id);
        if (result.isPresent()) return result.get();
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<EmployeeDTO> getAll() {
        return dao.findAll();
    }

//    @PatchMapping("{id}/{firstName}")
//    public ResponseEntity<String> updateFirstName(@PathVariable int id, @PathVariable String firstName){
//
//        ResponseEntity<String> result = null;
//        Optional<EmployeeDTO> optional = DAO.findById(id);
//        if (optional.isPresent()){
//            EmployeeDTO item = optional.get();
//            item.setFirstName(firstName);
//            DAO.update(item);
//            try {
//                result = new ResponseEntity<>(
//                        objectMapper.writeValueAsString(item), httpHeaders,
//                        HttpStatus.OK);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            result =
//                    new ResponseEntity<>("{\"message\": \"Employee not found\"}",
//                            httpHeaders, HttpStatus.OK);
//        }
//        return result;
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable int id) {
//        ResponseEntity<String> result;
//        if (DAO.deleteById(id)) {
//            result = new ResponseEntity<>("Deleted Employee " + id, httpHeaders,
//                    HttpStatus.OK);
//        } else {
//            result = new ResponseEntity<>("Employee not found", httpHeaders,
//                    HttpStatus.OK);
//        }
//        return result;
//    }
}