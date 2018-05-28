package com.example.mana.newsfinder.ui.screens.activities.webactivity.activity.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import at.markushi.ui.CircleButton;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.data.realmdatabase.DatabaseTransactions;
import com.example.mana.newsfinder.data.realmdatabase.favourites;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseActivity;
import com.example.mana.newsfinder.ui.screens.activities.webactivity.activity.presenter.WebActivityPresenter;
import com.example.mana.newsfinder.utilities.CommonUtils;
import com.wang.avi.AVLoadingIndicatorView;
import im.delight.android.webview.AdvancedWebView;
import java.util.List;

public class WebActivity extends BaseActivity implements AdvancedWebView.Listener {

  @BindView(R.id.progress_view) AVLoadingIndicatorView progressView;
  @BindView(R.id.web_news_view) AdvancedWebView webView;
  @BindView(R.id.fav_btn) CircleButton favBtn;

  @BindString(R.string.alert_title) String title;
  @BindString(R.string.alert_content) String content;

  WebActivityPresenter presenter;


  @Override public void init(Bundle savedState) {
    setUpWebview();
    presenter = new WebActivityPresenter(getnContext());
  }

  private news.articles getItemData() {
    List<news.articles> articles = getIntent().getParcelableArrayListExtra("data");
    int pos = getIntent().getExtras().getInt("pos");
    return articles.get(pos);
  }

  private void setUpWebview() {
    webView.setListener(getnContext(), this);
    webView.loadUrl(getItemData().getNewsUrl());
  }

  @Override public int layoutResource() {
    return R.layout.webview_fragment;
  }

  @Override public void setUpToolbar() {

  }

  @OnClick({ R.id.fav_btn })
  public void OnClick(View v) {
    switch (v.getId()) {
      case R.id.fav_btn:
        presenter.setFavourite(getItemData(), getIntent().getStringExtra("date"), title, content);
    }
  }

  private void startProgressAnim() {
    progressView.smoothToShow();
  }

  private void stopProgressAnim() {
    progressView.smoothToHide();
  }

  @Override protected void onResume() {
    super.onResume();
    webView.onResume();
  }

  @Override protected void onPause() {
    webView.onPause();
    super.onPause();
  }

  @Override protected void onDestroy() {
    webView.onDestroy();
    super.onDestroy();
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    webView.onActivityResult(requestCode, resultCode, data);
  }

  @Override public void onPageStarted(String url, Bitmap favicon) {
    webView.setVisibility(View.GONE);
    startProgressAnim();
  }

  @Override public void onPageFinished(String url) {
    webView.setVisibility(View.VISIBLE);
    stopProgressAnim();
  }

  @Override public void onPageError(int errorCode, String description, String failingUrl) {

  }

  @Override public void onDownloadRequested(String url, String suggestedFilename, String mimeType,
      long contentLength, String contentDisposition, String userAgent) {

  }

  @Override public void onExternalPageRequest(String url) {

  }
}
