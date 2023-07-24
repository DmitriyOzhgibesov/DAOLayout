package ru.netology.daolayout.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daolayout.DBRepository;

@RestController
@RequestMapping("/")
public class DAOLayoutController {
    private DBRepository dbRepository;

    public DAOLayoutController(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @GetMapping("products/fetch-product")
    public String getProductName(String name) {
        return dbRepository.getProductName(name);
    }
}