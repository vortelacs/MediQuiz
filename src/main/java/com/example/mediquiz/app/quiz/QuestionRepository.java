package com.example.mediquiz.app.quiz;

import com.example.mediquiz.app.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

/*
    @Query(value = "{}", sort = "{ $sample: { size: 142 } }")
    public List<Question> getQuickQuiz(String section){


    }
*/


}
