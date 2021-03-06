package myour.myourforumapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import myour.myourforumapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findByCategoryId(int categoryId, Pageable pageable);

    Page<Post> findByTitleIgnoreCaseContainingOrContentIgnoreCaseContaining
            (String title, String content, Pageable pageable);

    Page<Post> findByCategoryIdAndTitleIgnoreCaseContainingOrCategoryIdAndContentIgnoreCaseContaining
            (int categoryId, String title, int categoryId2, String content, Pageable pageable);
}
