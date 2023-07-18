package com.example.mediquiz.app.model.dto;

import com.example.mediquiz.app.model.Answer;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
public class QuestionDTO {

    private String id;
    private String question;
    private List<Answer> answers;
}