package edu.icet.model.dto;

import lombok. *;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponseDTO {

    private Long id;
    private String title;
    private String summary;
    private String content;
    private String authorName;
    private Integer likesCount;
    private Integer commentsCount;

}
