package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
}
