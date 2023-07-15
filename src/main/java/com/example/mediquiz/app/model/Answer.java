package com.example.mediquiz.app.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collection = "answers")
public class Answer {
    private String text;
    private boolean isCorrect;
}
