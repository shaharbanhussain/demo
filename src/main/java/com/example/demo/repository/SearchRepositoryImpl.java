package com.example.demo.repository;

import com.example.demo.model.Post;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Post> searchByText(String text) {

        MongoDatabase database = mongoClient.getDatabase("shaharban");
        MongoCollection<Document> collection = database.getCollection("jobpost");

        final List<Post> posts = new ArrayList<>();
        Iterable<Document> result= collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text)
                                .append("path", Arrays.asList("profile", "description", "technology")))),
                        new Document("$sort", new Document("experience", 1L)),
                        new Document("$limit", 5L)
        ));
        result.forEach(doc -> posts.add( mongoConverter.read(Post.class,doc)));
        return posts;

    }
}