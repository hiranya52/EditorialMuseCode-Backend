package edu.icet.controller;

import edu.icet.model.dto.ArticleRequestDTO;
import edu.icet.model.entity.Article;
import edu.icet.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody ArticleRequestDTO dto) {
        return articleService.createArticle(dto, 1L);
    }

}
