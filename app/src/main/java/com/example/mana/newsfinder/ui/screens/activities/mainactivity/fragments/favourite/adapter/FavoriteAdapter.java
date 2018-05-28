package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.adapter;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.data.realmdatabase.favourites;
import com.example.mana.newsfinder.ui.screens.activities.base.base.adapter.BaseRecyclerAdapter;
import com.example.mana.newsfinder.ui.screens.activities.base.base.adapter.BaseViewHolder;
import com.example.mana.newsfinder.ui.screens.activities.webactivity.activity.activity.WebActivity;
import com.example.mana.newsfinder.utilities.ActivityUtil;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends BaseRecyclerAdapter<favourites, BaseViewHolder> {

  public FavoriteAdapter(
      List<favourites> items) {
    super(items);
  }

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inf = inflater(parent.getContext());
    View favView = inf.inflate(R.layout.nf_single_article, parent, false);
    return new FavHolder(favView);
  }

  @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
    FavHolder hold = (FavHolder) holder;
    hold.articleTitle.setText(getItemAtPosition(position).getTitle());
    hold.articleDate.setText(getItemAtPosition(position).getDate());
    Picasso.with(hold.itemView.getContext()).load(getItemAtPosition(position).getImgUrl()).into(hold.articleImage);
  }

  class FavHolder extends BaseViewHolder {

    @BindView(R.id.article_date) TextView articleDate;
    @BindView(R.id.article_title) TextView articleTitle;
    @BindView(R.id.article_read_more) TextView articleMore;
    @BindView(R.id.article_img) ImageView articleImage;

    public FavHolder(View itemView) {
      super(itemView);
    }
    @OnClick({ R.id.article_read_more })
    public void onClickView() {

    }
  }
}
