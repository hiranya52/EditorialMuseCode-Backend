package edu.icet.service;

import edu.icet.model.entity.Follower;
import edu.icet.model.entity.User;
import edu.icet.repository.FollowerRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowerRepository followerRepository;
    private final UserRepository userRepository;

    public void followUser(Long followerId, Long followingId) {

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found"));

        Follower follow = Follower.builder()
                .follower(follower)
                .following(following)
                .build();

        followerRepository.save(follow);
    }

}

