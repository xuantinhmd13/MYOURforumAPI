package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import myour.myourforumapi.service.ImageService;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    //upload image.
    @PostMapping("/image")
    public String uploadImage(@RequestPart(name = "image") MultipartFile image) {
        {
            try {
                imageService.saveImage(image);
                return image.getOriginalFilename();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    //download image.
    @GetMapping("/image/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadImage(@PathVariable String fileName) throws IOException {
        return ResponseEntity.ok().body(imageService.loadAsResource(fileName));
    }
}
