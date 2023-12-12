package com.example.asterixapi;


import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AsterixService {

    private final CharacterRepository repo;

    public AsterixService(CharacterRepository repo) {
        this.repo = repo;
    }

    public List<Character> findAll() {
        return repo.findAll();
    }

    public int getNumberOfSmallCharacters() {
        List<Character> allCharacters = repo.findAll();

        int numberOfSmallCharacters = 0;
        for (Character character : allCharacters) {
            if (character.profession().contains("klein")) {
                numberOfSmallCharacters++;
            }
        }
        return numberOfSmallCharacters;
    }

    public Character update(String id, Character newCharacter) {
        repo.deleteById(id);
        Character toUpdate = new Character(newCharacter.id(), newCharacter.name(), newCharacter.profession());
        return repo.save(toUpdate);
    }
    public Character save(String id, Character newCharacter) {
        Character toSave = new Character(newCharacter.id(), newCharacter.name(), newCharacter.profession());
        return repo.save(toSave);
    }
    public void deleteById(String id){
        repo.deleteById(id);
    }
}