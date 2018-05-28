package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.presenter;

import android.content.Context;
import com.example.mana.newsfinder.data.realmdatabase.DatabaseTransactions;
import com.example.mana.newsfinder.data.realmdatabase.favourites;
import java.util.ArrayList;
import java.util.List;

public class FavoritesFragmentPresenter {

  Context ctx;
  view_favoriteFragment
      view_favoriteFragment;
  List<favourites> favoritesList = new ArrayList<>();

  public FavoritesFragmentPresenter(Context ctx, view_favoriteFragment favlist) {
    this.ctx = ctx;
    this.view_favoriteFragment = favlist;
  }

  public void loadFavourites() {
    for (favourites fav : DatabaseTransactions.selectAllFromDb(ctx)) {
      favoritesList.add(fav);
    }
    view_favoriteFragment.favList(favoritesList);
  }
}
