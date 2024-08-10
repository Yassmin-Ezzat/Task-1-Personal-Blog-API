package com.personalblogapi.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalblogapi.demo.model.Article;
import com.personalblogapi.demo.repository.ArticleRepository;

@Service
public class ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles()
    {
        return articleRepository.findAll();
    }

    public Article getArticleById(int Id)
    {
        
        return articleRepository.findById(Id);
    }

    public Article createArticle(Article article)
    {
        return articleRepository.save(article);
    }

    public Article updateArticle(int Id, String title, String content)
    {
        Article article  = articleRepository.findById(Id);
        article.setId(Id);
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.save(article);
    }

    public void deleteArticle(int Id)
    {
        articleRepository.deleteById(Id);
    }
}
