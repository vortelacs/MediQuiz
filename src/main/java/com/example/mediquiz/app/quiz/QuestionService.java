package com.example.mediquiz.app.quiz;


import com.example.mediquiz.app.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public QuestionService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Question> getQuickQuiz() {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.sample(15)
        );

        AggregationResults<Question> results = mongoTemplate.aggregate(agg, "questions", Question.class);
        List<Question> randomQuestions = results.getMappedResults();

        return randomQuestions;
    }
}