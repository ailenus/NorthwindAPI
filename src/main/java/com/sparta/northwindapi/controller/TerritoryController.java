package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.dao.DAO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/territory")
public class TerritoryController {

    DAO<TerritoryDTO> dao;

    public TerritoryController(DAO<TerritoryDTO> dao) {
        this.dao = dao;
    }

    @GetMapping({"","/"})
    public String basic() {
        return "territory/territory.html";
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String getById(@PathVariable int id, Model model) {
        Optional<TerritoryDTO> result = dao.findById(id);
        if (result.isPresent()) model.addAttribute("territory", result.get());
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return "territory/territory-id.html";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String getAll(Model model) {
        model.addAttribute("territories", dao.findAll());
        return "territory/territory-all.html";
    }

}