package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.presenter;

import com.example.mana.newsfinder.data.model.news;
import java.util.List;

public interface view_searchFragment {
  void setSearchList(List<news.articles> articles);
}
