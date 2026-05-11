package edu.icet.service;

import edu.icet.model.dto.InterestRequestDTO;
import edu.icet.model.entity.Category;
import edu.icet.model.entity.User;
import edu.icet.model.entity.UserInterest;
import edu.icet.repository.CategoryRepository;
import edu.icet.repository.UserInterestRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterestService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final UserInterestRepository userInterestRepository;

    public void saveUserInterests(Long userId, InterestRequestDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        dto.getCategoryIds().forEach(categoryId -> {

            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            UserInterest interest = UserInterest.builder()
                    .user(user)
                    .category(category)
                    .build();

            userInterestRepository.save(interest);
        });
    }

}
