package edu.icet.controller;

import edu.icet.model.dto.InterestRequestDTO;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtUtil;
import edu.icet.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interests")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService interestService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public String saveInterests(@RequestHeader("Authorization") String token, @RequestBody InterestRequestDTO dto) {
        String email = jwtUtil.extractEmail(token.substring(7));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        interestService.saveUserInterests(user.getId(), dto);

        return "Interests Saved Successfully";
    }

}
