package ru.netology.daolayout.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.netology.daolayout.model.Person;
import ru.netology.daolayout.repository.DaoRepository;

import java.awt.*;

@RestController
public class DaoController {

    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("products/fetch-product")
    public String getSqlSetup(@RequestParam String name) {
        return daoRepository.getProductName(name);
    }
    @PostMapping("/post")
    public String getSqlSetups(@RequestParam String name) {
        return daoRepository.getProductName(name);
    }
}
