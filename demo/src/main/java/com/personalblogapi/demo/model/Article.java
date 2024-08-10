package com.personalblogapi.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;


@Entity
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
        private int id;
        private String title;
        private String content;


    public Article() {
    }

    public Article(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article id(int id) {
        setId(id);
        return this;
    }

    public Article title(String title) {
        setTitle(title);
        return this;
    }

    public Article content(String content) {
        setContent(content);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Article)) {
            return false;
        }
        Article blog = (Article) o;
        return id == blog.id && Objects.equals(title, blog.title) && Objects.equals(content, blog.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
        

}
