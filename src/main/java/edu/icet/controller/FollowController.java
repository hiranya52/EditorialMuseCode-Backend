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
    public String followUser(@RequestBody FollowRequestDTO dto) {

        followService.followUser(1L, dto.getFollowingUserId());

        return "Followed Successfully";
    }

}
