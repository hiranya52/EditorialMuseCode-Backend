package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok. *;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String title;

    @Column(unique = true)
    private String slug;

    private String summary;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String coverImage;

    private Integer readingTime;

    private String status;

    private Integer views = 0;

    private Integer likesCount = 0;

    private Integer commentsCount = 0;

    private LocalDateTime publishedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
