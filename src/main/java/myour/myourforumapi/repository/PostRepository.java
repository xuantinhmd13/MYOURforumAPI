package myour.myourforumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myour.myourforumapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
