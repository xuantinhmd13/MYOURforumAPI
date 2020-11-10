package myour.myourforumapi.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    private final String IMAGE_UPLOAD_DIR = "./upload/image";

    public void saveImage(MultipartFile imageFile) throws IOException {
        Path path = Paths.get(IMAGE_UPLOAD_DIR + "/", imageFile.getOriginalFilename());
        Files.write(path, imageFile.getBytes());
    }

    public Resource loadAsResource(String fileName) throws MalformedURLException {
        Path imageFilePath = Paths.get(IMAGE_UPLOAD_DIR + "/" + fileName);
        return new UrlResource(imageFilePath.toUri());
    }
}
