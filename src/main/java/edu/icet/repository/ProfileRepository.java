package edu.icet.repository;

import edu.icet.model.entity.Profile;

import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> findByUserId(Long userId);

    Optional<Profile> findByUsername(String username);

}
