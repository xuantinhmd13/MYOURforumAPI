package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.service.PostService;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("hello")
    public String sayHello(){
        return "Hello MYOUR forum API";
    }

    //TEST API.
    @GetMapping("post/homepage")
    public Collection<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("post/list/by-category")
    public ResponseEntity<?> getPostByCategory(@RequestParam int categoryId, @RequestParam int pageIdx, @RequestParam int size) {
        List<Post> postList = postService.findByCategoryId(categoryId,
                (Pageable) PageRequest.of(pageIdx, size, Sort.by("createTime").descending()));
        if (postList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(postList, HttpStatus.OK);
        }
    }

    @PostMapping("post/image")
    public String uploadImage(@RequestPart(name = "image") MultipartFile image) {
        {
            try {
                postService.saveImage(image);
                return image.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
                return "NULL";
            }
        }
    }
}
