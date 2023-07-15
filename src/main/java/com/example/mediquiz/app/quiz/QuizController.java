package com.example.mediquiz.app.quiz;

import com.example.mediquiz.app.model.Question;
import com.example.mediquiz.app.question.QuestionAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/quick")
    public List<Question> getQuickQuiz(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        return questionService.getQuickQuiz();
    }
}