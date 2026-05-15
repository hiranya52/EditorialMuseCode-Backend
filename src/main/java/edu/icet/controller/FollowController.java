package edu.icet.controller;

import edu.icet.model.dto.FollowRequestDTO;
import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtUtil;
import edu.icet.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;


    @PostMapping
    public String followUser(
            @RequestHeader("Authorization") String token,
            @RequestBody FollowRequestDTO dto
    ) {

        String email = jwtUtil.extractEmail(token.substring(7));

        User follower = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        followService.followUser(
                follower.getId(),
                dto.getFollowingUserId()
        );

        return "Followed Successfully";
    }

}
