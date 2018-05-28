package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseFragment;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.adapter.NewsAdapter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.presenter.HomeFragmentPresenter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.presenter.view_homeFragment;
import com.example.mana.newsfinder.utilities.CommonUtils;
import java.util.List;

public class HomeFragment extends BaseFragment implements view_homeFragment {

  @BindView(R.id.news_list) RecyclerView newsList;

  HomeFragmentPresenter presenter;

  public static HomeFragment getInstance() {
    return new HomeFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.home_fragment;
  }

  @Override protected void init(Bundle savedState) {
    CommonUtils.RecyclerConfiguration(getFragContext(), newsList);
    presenter = new HomeFragmentPresenter(getFragContext(), this);
    presenter.getArticles();
  }

  @Override public void getNews(final List<news.articles> articles) {
    NewsAdapter adapter = new NewsAdapter(articles);
    newsList.setAdapter(adapter);
  }
}

