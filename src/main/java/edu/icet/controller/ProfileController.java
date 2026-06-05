package edu.icet.controller;

import edu.icet.model.dto.ProfileDTO;
import edu.icet.model.entity.Profile;
import edu.icet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // =========================================
    // GET PROFILE BY USER ID
    // =========================================

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfile(
            @PathVariable Long userId
    ) {

        Profile profile = profileService.getByUserId(userId);

        ProfileDTO dto = ProfileDTO.builder()
                .id(profile.getId())
                .userId(profile.getUser().getId())
                .displayName(profile.getDisplayName())
                .username(profile.getUsername())
                .bio(profile.getBio())
                .profileImageUrl(profile.getProfileImageUrl())
                .followersCount(profile.getFollowersCount())
                .followingCount(profile.getFollowingCount())
                .articlesCount(profile.getArticlesCount())
                .build();

        return ResponseEntity.ok(dto);
    }

}
