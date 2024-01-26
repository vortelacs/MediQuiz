package com.example.mediquiz.app.quiz;


import com.example.mediquiz.app.model.Difficulty;
import com.example.mediquiz.app.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public QuestionService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Question> getQuickQuiz(int size) {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.sample(size)
        );


        return mongoTemplate.aggregate(agg, "questions", Question.class).getMappedResults();
    }

    public List<Question> getCustomQuiz(int size, Difficulty difficulty, String category){
        Aggregation agg = Aggregation
                    .newAggregation(Aggregation.match(Criteria.where("difficulty").is(difficulty)),
                            Aggregation.match(Criteria.where("category").is(category) ),
                Aggregation.sample(size)
        );

        return mongoTemplate.aggregate(agg, "questions", Question.class).getMappedResults();
    }

}