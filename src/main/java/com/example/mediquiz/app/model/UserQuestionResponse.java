package com.example.mediquiz.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Setter
@Getter
@Document(collection = "user_question_responses")
public class UserQuestionResponse {
    private String questionId;
    private List<String> selectedAnswerTexts;
    private boolean isCorrect;
}