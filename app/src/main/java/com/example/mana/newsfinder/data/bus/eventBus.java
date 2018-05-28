package com.example.mana.newsfinder.data.bus;

import com.example.mana.newsfinder.data.model.news;

public class eventBus {
  private news.articles article;

  public eventBus(news.articles articles) {
    this.article = articles;
  }

  public news.articles getArticles() {
    return article;
  }

  public void setArticles(news.articles article) {
    this.article = article;
  }
}
