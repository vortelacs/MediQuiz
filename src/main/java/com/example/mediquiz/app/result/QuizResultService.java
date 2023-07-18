package com.example.mediquiz.app.result;

import com.example.mediquiz.app.model.QuizResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizResultService {
    private final QuizResultRepository quizResultRepository;

    public QuizResult saveQuizResult(QuizResult quiz) {
        return quizResultRepository.save(quiz);
    }

    public List<QuizResult> getQuizResultsByUserId(String userId) {
        return quizResultRepository.findByUserId(userId);
    }
    public Optional<QuizResult> getQuizResultsById(String userId) {
        return quizResultRepository.findById(userId);
    }
}
