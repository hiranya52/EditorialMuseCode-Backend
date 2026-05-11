package edu.icet.service;

import edu.icet.model.dto.CategoryRequestDTO;
import edu.icet.model.entity.Category;
import edu.icet.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequestDTO dto) {

        Category category = Category.builder()
                .name(dto.getName())
                .build();

        return categoryRepository.save(category);
    }

}
