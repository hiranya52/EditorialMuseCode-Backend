package edu.icet.controller;

import edu.icet.model.dto.CategoryRequestDTO;
import edu.icet.model.entity.Category;
import edu.icet.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequestDTO dto) {
        return categoryService.createCategory(dto);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
