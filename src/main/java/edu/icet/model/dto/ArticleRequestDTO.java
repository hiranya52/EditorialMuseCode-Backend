package edu.icet.model.dto;

import lombok. *;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequestDTO {

    private String title;
    private String summary;
    private String content;
    private String coverImage;
    private String status;

}
