package myour.myourforumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import myour.myourforumapi.repository.CategoryRepository;
import myour.myourforumapi.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
