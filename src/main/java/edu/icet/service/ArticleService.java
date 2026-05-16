package edu.icet.service;

import edu.icet.model.dto.ArticleRequestDTO;
import edu.icet.model.entity.Article;
import edu.icet.model.entity.User;
import edu.icet.repository.ArticleRepository;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public Article createArticle(ArticleRequestDTO dto, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Article article = Article.builder()
                .title(dto.getTitle())
                .summary(dto.getSummary())
                .content(dto.getContent())
                .coverImage(dto.getCoverImage())
                .status(dto.getStatus())
                .author(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return articleRepository.save(article);
    }

}
