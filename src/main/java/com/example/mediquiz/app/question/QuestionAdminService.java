package com.example.mediquiz.app.question;

import com.example.mediquiz.app.model.Question;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionAdminService {

    private final QuestionAdminRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getRandomQuestions(int page, int size) {
        return questionRepository.findRandomQuestions(PageRequest.of(page, size));
    }
}