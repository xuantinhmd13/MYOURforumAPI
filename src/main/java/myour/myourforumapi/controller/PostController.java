package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;
import myour.myourforumapi.service.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello MYOUR forum API";
    }

    //TEST API.
    @GetMapping("/posts")
    public ResponseEntity<?> getAllPost() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/posts/by-category-id")
    public ResponseEntity<?> getPostByCategoryId(@RequestParam int categoryId, @RequestParam int pageIdx, @RequestParam int size) {
        List<Post> postList;
        Pageable pageable = (Pageable) PageRequest.of(pageIdx, size, Sort.by("createTime").descending());
        if (categoryId == 0) {
            postList = postRepository.findAll(pageable).getContent();
        } else
            postList = postRepository.findByCategoryId(categoryId, pageable).getContent();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}
