package controller;

import lombok.RequiredArgsConstructor;
import model.dto.CategoryDTO;
import model.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 🔓 Public API
    @GetMapping("/public")
    public String publicApi() {
        return "Public API working";
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO request) {

        return userService.registerLocalUser(
                request.getFullName(),
                request.getEmail(),
                "1234" // temporary if no password field yet
        );
    }

    // 🔐 Save categories (PERSONALIZE FEED)
    @PostMapping("/categories")
    public UserDTO saveCategories(
            @RequestBody CategoryDTO request,
            Authentication authentication
    ) {
        String email = authentication.getName();
        return userService.saveUserCategories(email, request.getCategoryIds());
    }

    // 🔐 Get profile
    @GetMapping("/profile")
    public UserDTO getProfile(Authentication authentication) {
        String email = authentication.getName();
        return userService.getUserProfile(email);
    }

}
