package com.example.demo.controller;
import java.util.List;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/getAllJobPosts")
    public List<Post> getAllJobPosts(){
       return postRepository.findAll();
    }

    @PostMapping("/addJobPost")
    public Post addJobPost( Post post){
        return postRepository.save(post);
    }


}