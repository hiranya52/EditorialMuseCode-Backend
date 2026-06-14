package edu.icet.service;

import edu.icet.mapper.ProfileMapper;
import edu.icet.model.dto.ProfileDTO;
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
                .profileImageUrl("data:image/png;base64,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")
                .followersCount(0)
                .followingCount(0)
                .articlesCount(0)
                .build();

        profileRepository.save(profile);
    }

    // GET PROFILE
    public ProfileDTO getByUserId(Long userId) {

        Profile entity = profileRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found"));

        return ProfileMapper.toDTO(entity);
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


