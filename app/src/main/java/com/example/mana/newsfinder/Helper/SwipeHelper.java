package com.example.mana.newsfinder.Helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.adapter.NewsAdapter;

public class SwipeHelper extends ItemTouchHelper.SimpleCallback {
  NewsAdapter adapter;
  public SwipeHelper(int dragDirs, int swipeDirs) {
    super(dragDirs, swipeDirs);
  }

  public SwipeHelper(NewsAdapter adapter) {
    super(ItemTouchHelper.UP | ItemTouchHelper.DOWN ,ItemTouchHelper.LEFT);
    this.adapter = adapter;
  }

  @Override public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
      RecyclerView.ViewHolder target) {
    return false;
  }

  @Override public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
  adapter.dismissItem(viewHolder.getLayoutPosition());
  }
}
