package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {

    private Long id;

    private Long userId;

    private String displayName;

    private String username;

    private String bio;

    private String profileImageUrl;

    private Integer followersCount;

    private Integer followingCount;

    private Integer articlesCount;

}
