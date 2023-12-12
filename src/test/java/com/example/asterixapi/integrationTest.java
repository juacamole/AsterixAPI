package com.example.asterixapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class integrationTest {

    @Autowired
    private CharacterRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void shouldReturnAsterixAndObelix_whenTheyAreStoredInDb() throws Exception {

        repo.save(new Character("3", "Automatix", "Smith"));
        repo.save(new Character("4", "Miraculax", "Zauberer"));


        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/asterix/characters")
                )


                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content().json("""
                        [
                            {
                                "id": "3",
                                "name": "Automatix",
                                "profession": "Smith"
                            },
                            {
                                "id": "4",
                                "name": "Miraculax",
                                "profession": "Zauberer"
                            }
                        ]
""")
                );
    }

    @Test
    @DirtiesContext
    void ShouldReturnUpdatedVersionOfMiraculixWithId5() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/asterix/characters/4")
                        .content("""
                                 {
                                "id": "4",
                                "name": "Miraculix",
                                "profession": "Zauberer"
                                }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
        )

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                                {
                                "id": "4",
                                "name": "Miraculix",
                                "profession": "Zauberer"
                                }
""")
                );
    }

    @Test
    @DirtiesContext
    void ifDeletedReturnNull() throws Exception{

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/asterix/characters/3")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/asterix/characters/3")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json() """
                
                """);

    }

}