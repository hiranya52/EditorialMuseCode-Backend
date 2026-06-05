package edu.icet.service;

import edu.icet.model.entity.Profile;
import edu.icet.model.entity.User;
import edu.icet.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

}
