package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    //get post follow category.
    @GetMapping("/posts/by-category-id")
    public ResponseEntity<?> getPostByCategoryId(@RequestParam int categoryId, @RequestParam int pageIndexMain, @RequestParam int size) {
        List<Post> postList;
        Pageable pageable = (Pageable) PageRequest.of(pageIndexMain, size, Sort.by("createTime").descending());
        if (categoryId == 0) {
            postList = postRepository.findAll(pageable).getContent();
        } else
            postList = postRepository.findByCategoryId(categoryId, pageable).getContent();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<?> searchPost(@RequestParam String keyWord, @RequestParam int categoryId, @RequestParam int pageIndexSearch,
                                        @RequestParam int size) {
        String title = keyWord;
        String content = keyWord;
        List<Post> postList;
        Pageable pageable = PageRequest.of(pageIndexSearch, size, Sort.by("createTime").descending());
        if (categoryId == 0) {
            postList = postService.searchAll(title, content, pageable);
        } else {
            postList = postService.searchByCategoryId(categoryId, title, content, pageable);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PutMapping("/posts/{id}/view-count")
    public int increaseViewCount(@RequestParam int id) {
        return postService.increaseViewCount(id);
    }

    @PostMapping("/posts")
    public int addPost(@RequestBody Post newPost) {
        return postRepository.save(newPost).getId();
    }

    @PutMapping("/posts/{id}")
    public int updatePost(@RequestBody Post postEdited) {
        Post post = postRepository.findById(postEdited.getId()).get();
        postEdited.setHasImage(post.isHasImage());
        postEdited.setViewCount(post.getViewCount());
        return postRepository.save(postEdited).getId();
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@RequestParam int id) {
        postRepository.deleteById(id);
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@RequestParam int id) {
        return postRepository.findById(id).get();
    }
}
