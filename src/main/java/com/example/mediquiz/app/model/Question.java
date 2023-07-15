package com.example.mediquiz.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Setter
@Getter
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String category;
    @Indexed(unique = true)
    private String question;
    private List<Answer> answers;
    private Difficulty difficulty;
}

