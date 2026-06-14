package edu.icet.controller;

import edu.icet.model.dto.ProfileDTO;
import edu.icet.model.dto.UpdateProfileRequest;
import edu.icet.model.entity.Profile;
import edu.icet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    @Autowired
    private ProfileService profileService;


    // GET PROFILE BY USER ID
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDTO> getProfile(
            @PathVariable Long userId
    ) {

        ProfileDTO dto = profileService.getByUserId(userId);

        return ResponseEntity.ok(dto);
    }


    // UPDATE PROFILE
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateProfile(
            @PathVariable Long userId,
            @RequestBody UpdateProfileRequest request
    ) {

        Profile updatedProfile =
                profileService.updateProfile(userId, request);

        ProfileDTO dto = ProfileDTO.builder()
                .id(updatedProfile.getId())
                .userId(updatedProfile.getUser().getId())
                .displayName(updatedProfile.getDisplayName())
                .username(updatedProfile.getUsername())
                .bio(updatedProfile.getBio())
                .profileImageUrl(updatedProfile.getProfileImageUrl())
                .followersCount(updatedProfile.getFollowersCount())
                .followingCount(updatedProfile.getFollowingCount())
                .articlesCount(updatedProfile.getArticlesCount())
                .build();

        return ResponseEntity.ok(
                Map.of(
                        "message", "Profile updated successfully",
                        "profile", dto
                )
        );
    }

}
