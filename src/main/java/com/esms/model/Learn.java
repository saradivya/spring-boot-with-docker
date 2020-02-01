package com.esms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Learn")
public class Learn {

    @Id
    public String id;

    public String course;
    public String language;

    public Learn() {}

    public Learn(String course, String language) {
        this.course = course;
        this.language = language;
    }

}
