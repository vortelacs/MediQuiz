package com.example.mediquiz.app.result;

import com.example.mediquiz.app.model.QuizResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/results")
@AllArgsConstructor
public class QuizResultController {

    private final QuizResultService quizResultService;
    @PostMapping("/save")
    public QuizResult saveQuizResult(@RequestBody QuizResult quiz) {
        return quizResultService.saveQuizResult(quiz);
    }

    @PostMapping("/all")
    public List<QuizResult> getQuizResultsByUserId(@RequestBody String userId) {
        return quizResultService.getQuizResultsByUserId(userId);
    }

    @PostMapping("/{id}")
    public Optional<QuizResult> getQuizResultById(@PathVariable String id) {
        return quizResultService.getQuizResultsById(id);
    }

}
