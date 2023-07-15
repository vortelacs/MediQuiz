package com.example.mediquiz.app.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sections")
public class Section {
    @Id
    private String id;
    private String name;

}