package com.example.mediquiz.app.question;

import com.example.mediquiz.app.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionAdminRepository extends MongoRepository<Question, String> {


    @Query(value = "{}", sort = "{ $sample: { size: ?0 } }")
    List<Question> findRandomQuestions(Pageable pageable);
}