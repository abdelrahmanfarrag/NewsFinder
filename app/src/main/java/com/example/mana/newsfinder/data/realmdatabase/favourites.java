package com.example.mana.newsfinder.data.realmdatabase;

import com.example.mana.newsfinder.data.model.news;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.sql.Date;
import java.util.List;

public class favourites extends RealmObject {
  @PrimaryKey
  private int id;
  private String title,newsUrl,imgUrl,date,author;

  public favourites() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getNewsUrl() {
    return newsUrl;
  }

  public void setNewsUrl(String newsUrl) {
    this.newsUrl = newsUrl;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
