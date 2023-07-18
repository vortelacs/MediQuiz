package com.example.mediquiz.app.quiz;

import com.example.mediquiz.app.model.dto.QuestionDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
public class QuizController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @GetMapping("/quick")
    public List<QuestionDTO> getQuickQuiz(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        return questionService.getQuickQuiz().stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }
}