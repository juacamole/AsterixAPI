package com.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface CharacterRepository extends MongoRepository<Character, String>{}
