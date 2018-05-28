package com.example.mana.newsfinder.ui.screens.activities.webactivity.activity.presenter;

import android.content.Context;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.data.realmdatabase.DatabaseTransactions;
import com.example.mana.newsfinder.data.realmdatabase.favourites;

public class WebActivityPresenter {
  Context ctx;
  public WebActivityPresenter(Context ctx){
    this.ctx=ctx;
  }
  public void setFavourite(news.articles article,String date,String title,String content){
    favourites fav = new favourites();
    fav.setAuthor(article.getAuthor());
    fav.setDate(date);
    fav.setImgUrl(article.getImgUrl());
    fav.setNewsUrl(article.getNewsUrl());
    fav.setTitle(article.getNewsTitle());
    DatabaseTransactions.insertData(ctx, fav,title,content);
  }

}
