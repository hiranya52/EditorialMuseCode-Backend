package edu.icet.mapper;

import edu.icet.model.dto.ProfileDTO;
import edu.icet.model.entity.Profile;

public class ProfileMapper {

    public static ProfileDTO toDTO(Profile profile) {
        return ProfileDTO.builder()
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
    }

}
