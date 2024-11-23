package com.absattarov.PostgreSql_REST.controller;

import com.absattarov.PostgreSql_REST.model.Dog;
import com.absattarov.PostgreSql_REST.repositories.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
public class DogController {
    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/all")
    public List<Dog> getAll(){
        return dogRepository.findAll();
    }
    @GetMapping()
    public ResponseEntity<Dog> getByName(@RequestParam String name){
        var dog = dogRepository.findByName(name);
        if(dog==null){
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
        }
        return new ResponseEntity<>(dog,HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public Dog addDog(@RequestBody Dog dog){
        dog.setId(UUID.randomUUID());
        return dogRepository.save(dog);
    }
}
