package com.example.mediquiz.app.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document(collection = "quiz_results")
public class QuizResult {
    @Id
    private String id;
    private String userId;
    private List<UserQuestionResponse> responses;
}
