package myour.myourforumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import myour.myourforumapi.model.Category;
import myour.myourforumapi.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<String> getAllCategoryName() {
        List<String> categoryListName = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            categoryListName.add(category.getName());
        }
        return categoryListName;
    }
}
