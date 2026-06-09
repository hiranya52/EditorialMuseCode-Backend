package edu.icet.service;

import edu.icet.model.dto.UpdateProfileRequest;
import edu.icet.model.entity.Profile;
import edu.icet.model.entity.User;
import edu.icet.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    // CREATE EMPTY PROFILE
    public void createProfile(User user) {

        Profile profile = Profile.builder()
                .user(user)
                .displayName(user.getFullName())
                .bio(null)
                .username(null)
                .profileImageUrl(null)
                .followersCount(0)
                .followingCount(0)
                .articlesCount(0)
                .build();

        profileRepository.save(profile);
    }

    // GET PROFILE
    public Profile getByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    // UPDATE PROFILE
    public Profile updateProfile(
            Long userId,
            UpdateProfileRequest request
    ) {

        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        profile.setDisplayName(request.getDisplayName());
        profile.setUsername(request.getUsername());
        profile.setBio(request.getBio());
        profile.setProfileImageUrl(request.getProfileImageUrl());

        return profileRepository.save(profile);
    }

}


