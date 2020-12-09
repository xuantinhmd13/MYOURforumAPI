package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import myour.myourforumapi.model.Post;
import myour.myourforumapi.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public int increaseViewCount(int id) {
        Post post = postRepository.findById(id).get();
        post.setViewCount(post.getViewCount() + 1);
        return postRepository.save(post).getViewCount();
    }

    public List<Post> searchAll(String title, String content, Pageable pageable) {
        return postRepository.findByTitleIgnoreCaseContainingOrContentIgnoreCaseContaining
                (title, content, pageable)
                .getContent();
    }

    public List<Post> searchByCategoryId(int categoryId, String title, String content, Pageable pageable) {
        return postRepository.findByCategoryIdAndTitleIgnoreCaseContainingOrCategoryIdAndContentIgnoreCaseContaining
                (categoryId, title, categoryId, content, pageable)
                .getContent();
    }
}
