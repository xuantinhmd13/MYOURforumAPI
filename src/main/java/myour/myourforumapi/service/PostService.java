package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import myour.myourforumapi.Program;
import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private ServletContext context;

    @Autowired
    private PostRepository postRepository;

    public Collection<Post> getAllPost() {
        return postRepository.findAll();
    }

    public List<Post> findByCategoryId(int categoryId, Pageable pageable) {
        if (categoryId == 0) {
            return postRepository.findAll(pageable).getContent();
        }
        return postRepository.findByCategoryId(categoryId, pageable).getContent();
    }

    public void saveImage(MultipartFile imageFile) throws IOException {
        Path path = Paths.get(Program.UPLOAD_DIR+"\\imagepost\\", imageFile.getOriginalFilename());
        Files.write(path, imageFile.getBytes());
    }
}
