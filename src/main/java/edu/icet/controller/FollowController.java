package edu.icet.controller;

import edu.icet.model.dto.FollowRequestDTO;
import edu.icet.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;


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
