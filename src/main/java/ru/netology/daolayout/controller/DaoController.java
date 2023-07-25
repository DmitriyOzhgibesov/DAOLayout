package ru.netology.daolayout.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.daolayout.repository.DaoRepository;

import java.util.*;

@RestController
public class DaoController {

    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("products/fetch-product")
    public List<String> getSqlSetup(@RequestParam String name) {
        return daoRepository.getProductName(name);
    }
    @PostMapping("/post")
    public List<String> getSqlSetups(@RequestParam String name) {
        return daoRepository.getProductName(name);
    }
}