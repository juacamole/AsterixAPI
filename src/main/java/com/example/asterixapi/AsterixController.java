package com.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService service;
    @GetMapping
    List<Character> findAll() {
        return service.findAll();
    }
    @PutMapping("/{id}")
    Character save(@PathVariable String id, @RequestBody Character newCharacter) {
        return service.update(id, newCharacter);
    }

    @PostMapping("/{id}")
    Character post(@PathVariable String id, @RequestBody Character newCharacter) {
        return  service.save(id, newCharacter);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        service.deleteById(id);
    }
}

