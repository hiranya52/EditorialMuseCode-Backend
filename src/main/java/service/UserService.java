package service;


import lombok. *;
import model.dto.CategoryDTO;
import model.dto.UserDTO;
import model.entity.Category;
import model.entity.User;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import repository.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static mapper.UserMapper.mapToDTO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    // 🔐 OAuth user creation
    public User processOAuthUser(String email, String name, String provider) {
        return userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User user = new User();
                    user.setEmail(email);
                    user.setFullName(name);
                    user.setProvider(provider);
                    return userRepository.save(user);
                });
    }

    // 🎯 Save selected categories
    public UserDTO saveUserCategories(String email, Set<Long> categoryIds) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Set<Category> categories;
        categories = new HashSet<Category>(categoryRepository.findById(categoryIds));

        user.setCategories(categories);

        User saved = userRepository.save(user);

        return mapToDTO(saved);
    }

    // 🔍 Get user profile
    public UserDTO getUserProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }



}
