package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.presenter;

import com.example.mana.newsfinder.data.model.news;
import java.util.List;

public interface view_homeFragment {
  void getNews(List<news.articles> articles);
}
