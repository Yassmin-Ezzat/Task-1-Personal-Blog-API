package com.personalblogapi.demo.repository;

import com.personalblogapi.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
    Article findById(int Id);
    void deleteById(int Id);
}