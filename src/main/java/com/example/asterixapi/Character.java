package com.example.asterixapi;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Characters")
public record Character(
        String id,
        String name,
        String profession
) {
}
