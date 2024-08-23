package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository {
   List<Post> searchByText(String text);
}