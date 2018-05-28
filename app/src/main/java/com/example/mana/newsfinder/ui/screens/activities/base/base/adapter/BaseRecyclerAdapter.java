package com.example.mana.newsfinder.ui.screens.activities.base.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<I, H extends BaseViewHolder>
    extends RecyclerView.Adapter<H> {
  private List<I> items;

  public BaseRecyclerAdapter(List<I> items) {
    this.items = items;
  }

  protected LayoutInflater inflater(Context ctx) {
    return LayoutInflater.from(ctx);
  }

  protected I getItemAtPosition(final int pos) {
    return getItems().get(pos);
  }

  public List<I> getItems() {
    return items;
  }


  @Override public int getItemCount() {
    return items.size();
  }
}
