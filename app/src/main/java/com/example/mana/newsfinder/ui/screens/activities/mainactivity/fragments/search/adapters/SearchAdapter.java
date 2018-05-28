package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.adapters;

import android.content.Intent;
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
import com.example.mana.newsfinder.ui.screens.activities.base.base.adapter.BaseRecyclerAdapter;
import com.example.mana.newsfinder.ui.screens.activities.base.base.adapter.BaseViewHolder;
import com.example.mana.newsfinder.ui.screens.activities.webactivity.activity.activity.WebActivity;
import com.example.mana.newsfinder.utilities.ActivityUtil;
import com.example.mana.newsfinder.utilities.CommonUtils;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends BaseRecyclerAdapter<news.articles, BaseViewHolder> {

  public SearchAdapter(
      List<news.articles> items) {
    super(items);
  }

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = inflater(parent.getContext());
    View v = inflater.inflate(R.layout.nf_single_article, parent, false);

    return new SearchHolder(v);
  }

  @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
    SearchHolder hold = (SearchHolder) holder;
    hold.articleDate.setText("  " + CommonUtils.convertDateToString(
        getItemAtPosition(position).getPublishDate()));
    hold.articleTitle.setText(getItemAtPosition(position).getNewsTitle());
    Picasso.with(hold.itemView.getContext())
        .load(getItemAtPosition(position).getImgUrl())
        .placeholder(R.drawable.af_img)
        .into(hold.articleImage);
  }

  class SearchHolder extends BaseViewHolder {

    @BindView(R.id.article_date) TextView articleDate;
    @BindView(R.id.article_title) TextView articleTitle;
    @BindView(R.id.article_read_more) TextView articleMore;
    @BindView(R.id.article_img) ImageView articleImage;

    public SearchHolder(View itemView) {
      super(itemView);
    }

    @OnClick({ R.id.article_read_more })
    public void onClickView() {
      int pos = getLayoutPosition();
      //EventBus.getDefault().post(new eventBus(getItemAtPosition(pos)));
      Intent i = new Intent(itemView.getContext(), WebActivity.class);
      List<news.articles> list = getItems();
      i.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) list);
      i.putExtra("pos", pos);
      i.putExtra("date", articleDate.getText().toString());
      ActivityUtil.IntentExtra(itemView.getContext(), i);
    }
  }
}
