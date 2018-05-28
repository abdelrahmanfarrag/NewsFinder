package com.example.mana.newsfinder.ui.screens.activities.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.mana.newsfinder.utilities.ActivityUtil;

public abstract class BaseActivity extends AppCompatActivity {

  private Activity nContext;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layoutResource());
    nContext = this;
    ButterKnife.bind(this);
    ActivityUtil.setActivityAnimated(this);
  }

  @Override protected void onResume() {
    super.onResume();
    ActivityUtil.setActivityAnimated(this);
  }

  @Override protected void onPause() {
    super.onPause();
    ActivityUtil.setActivityAnimated(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ActivityUtil.setActivityAnimated(this);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    ActivityUtil.setActivityAnimated(this);
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    init(savedInstanceState);
    setUpToolbar();
  }

  public Activity getnContext() {
    return nContext;
  }

  public abstract void init(Bundle savedState);

  public abstract @LayoutRes int layoutResource();

  public abstract void setUpToolbar();
}
