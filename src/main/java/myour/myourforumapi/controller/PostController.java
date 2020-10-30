package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/homepage")
    public Collection<Post> getAllPost(){
        return postService.getAllPost();
    }

}
