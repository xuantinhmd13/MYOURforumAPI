package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import myour.myourforumapi.model.Category;
import myour.myourforumapi.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list/all-name")
    public List<String> getAllCategoryName() {
        return categoryService.getAllCategoryName();
    }
}
