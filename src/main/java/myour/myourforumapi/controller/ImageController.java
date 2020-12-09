package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;
import myour.myourforumapi.service.ImageService;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private PostRepository postRepository;

    //upload image.
    @PostMapping("/image/post/{id}")
    public void uploadImagePost(@RequestPart(name = "image") MultipartFile image, @RequestParam int id) throws IOException {
        {
            imageService.saveImage(image);
            Post post = postRepository.findById(id).get();
            post.setHasImage(true);
            postRepository.save(post);
        }
    }

    //download image.
    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
        return ResponseEntity.ok().body(imageService.loadAsResource(fileName));
    }
}
