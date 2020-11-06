package myour.myourforumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import myour.myourforumapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
