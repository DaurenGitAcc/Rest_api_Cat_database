package com.absattarov.PostgreSql_REST.controller;

import com.absattarov.PostgreSql_REST.model.Cat;
import com.absattarov.PostgreSql_REST.repositories.CatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final CatRepository catRepository;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
        log.info("New row added: "+ catRepository.save(cat));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll(){
        return catRepository.findAll();
    }

    @GetMapping("/api")
    public Cat getById(@RequestParam int id){
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteById(@RequestParam int id){
        catRepository.deleteById(id);
    }

    @PutMapping("/api")
    public String updateById(@RequestBody Cat cat){
        if(catRepository.existsById(cat.getId())){
            return catRepository.save(cat).toString();
        }
        return "Such row not exists";
    }

}
