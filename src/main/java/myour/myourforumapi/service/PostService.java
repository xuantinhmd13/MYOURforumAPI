package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Collection<Post> getAllPost() {
        return postRepository.findAll();
    }
}
