package com.personalblogapi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.personalblogapi.demo.model.Article;
import com.personalblogapi.demo.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController
{

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public ModelAndView getAllArticles()
    {
        ModelAndView mav = new ModelAndView("BlogArticles.html");
        List<Article> articles = this.articleService.getAllArticles();
        mav.addObject("articles", articles);
        return mav;
    }

    @GetMapping("/createarticle")
    public ModelAndView createArticle()
    {
        ModelAndView mav = new ModelAndView("CreateArticle.html");
        Article newArticle = new Article();
        mav.addObject("article", newArticle);
        return mav;
    }

    @PostMapping("/createarticle")
    public RedirectView saveArticle(@ModelAttribute Article article)
    {
        this.articleService.createArticle(article);
        return new RedirectView("/articles/");
    }

    @GetMapping("/update/{Id}")
    public ModelAndView update(@PathVariable("Id") int Id)
    {
        ModelAndView mav = new ModelAndView("UpdateArticle.html");
        Article article = this.articleService.getArticleById(Id);
        mav.addObject("article", article);
        return mav;
    }

    @PostMapping("/update")
    public RedirectView saveUpdatedArticle(@ModelAttribute Article article)
    {
        this.articleService.updateArticle(article.getId(),article.getTitle(),article.getContent());
        return new RedirectView("/articles/");
    }

    @GetMapping("/Delete/{Id}")
    public RedirectView deleteArticle(@PathVariable("Id") int Id)
    {
        this.articleService.deleteArticle(Id);
        return new RedirectView("/articles/");
    }
    
}