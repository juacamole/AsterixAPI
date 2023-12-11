package com.example.asterixapi;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AsterixApiApplicationTests {


    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private AsterixService asterixService;

    @Test
    void ifAllCharactersFoundTrue(){
        List<Character> given = Arrays.asList(
                new Character("1", "Asterix", "warrior", 23)
        );

        when(characterRepository.findAll()).thenReturn(given);
        List<Character> actual = asterixService.findAll();
        assertEquals(given, actual, "false");


    }

    @Test
    void  ifCharacterByIdWasFoundReturnTrue(){

        List<Character> given = Arrays.asList(
        );

    }


    }

