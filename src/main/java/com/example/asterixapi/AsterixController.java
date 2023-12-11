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
    List<ApiCharacter> findAll() {
        List<Character> charactersFromDatabase = service.findAll();
        List<ApiCharacter>  charactersToReturn = new ArrayList<>();
        for (Character character : charactersFromDatabase){
            ApiCharacter x = new ApiCharacter(
                    character.id(),
                    character.name(),
                    character.profession(),
                    character.age()
            );
            charactersToReturn.add(x);
        }
        return charactersToReturn;
    }
    @PostMapping("/post")
    public ApiCharacter createCharacter(@RequestBody ApiCharacter character) {
        return null; //service.createCharacter(character);
    }

    @PutMapping("/put/{id}")
    public ApiCharacter updateCharacter(@PathVariable Long id, @RequestBody ApiCharacter character) {
        return null;// service.updateCharacter(id, character);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        //service.deleteCharacter(id);
    }

    @GetMapping("/{id}")
    public ApiCharacter findCharacterById(@PathVariable Long id) {
        return null;//service.findCharacterById(id);
    }

}

