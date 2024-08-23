package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SearchRepository searchRepository;

    @GetMapping("/posts")
    public List<Post> getAllJobPosts(){
       return postRepository.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> searchPost(@PathVariable String text){
        return searchRepository.searchByText(text);
    }
    @PostMapping("/addJobPost")
    public Post addJobPost( Post post){
        return postRepository.save(post);
    }


}