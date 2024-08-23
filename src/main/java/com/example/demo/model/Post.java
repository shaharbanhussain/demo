package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@NoArgsConstructor
@Document(collection = "jobpost")
@Setter
@Getter
public class Post {
    String profile;
    String description;
    int experience;
    List<String> technology;

}