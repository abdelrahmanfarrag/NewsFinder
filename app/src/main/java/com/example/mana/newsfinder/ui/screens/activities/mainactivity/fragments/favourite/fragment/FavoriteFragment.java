package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.realmdatabase.favourites;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseFragment;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.adapter.FavoriteAdapter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.presenter.FavoritesFragmentPresenter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.presenter.view_favoriteFragment;
import com.example.mana.newsfinder.utilities.CommonUtils;
import java.util.List;

public class FavoriteFragment extends BaseFragment implements view_favoriteFragment {

  @BindView(R.id.favourite_list) RecyclerView favouriteList;

  FavoritesFragmentPresenter presenter;

  public static FavoriteFragment getInstance() {
    return new FavoriteFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.favorite_fragment;
  }

  @Override protected void init(Bundle savedState) {

    CommonUtils.RecyclerConfiguration(getFragContext(), favouriteList);
    presenter = new FavoritesFragmentPresenter(getFragContext(), this);
    presenter.loadFavourites();
  }

  @Override public void favList(List<favourites> favourites) {
    favouriteList.setAdapter(new FavoriteAdapter(favourites));

  }
}
