package com.example.mediquiz.app.quiz;

import com.example.mediquiz.app.model.Question;
import com.example.mediquiz.app.model.dto.QuestionDTO;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public QuestionDTO toDTO(Question question) {
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestion(question.getQuestion());
        dto.setAnswers(question.getAnswers());
        return dto;
    }

    public Question toEntity(QuestionDTO dto) {
        Question question = new Question();
        question.setQuestion(dto.getQuestion());
        question.setAnswers(dto.getAnswers());
        return question;
    }
}
