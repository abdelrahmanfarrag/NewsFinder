package com.example.mana.newsfinder.ui.screens.activities.mainactivity.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseActivity;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.favourite.fragment.FavoriteFragment;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.fragment.HomeFragment;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.fragment.SearchFragment;
import com.example.mana.newsfinder.utilities.ActivityUtil;
import com.example.mana.newsfinder.utilities.FragmentUtils;

public class MainActivity extends BaseActivity {

  @BindView(R.id.nf_toolbar) Toolbar toolbar;
  @BindView(R.id.toolbar_img) ImageView toolbarImage;
  @BindView(R.id.bottom_view) BottomNavigationView bottomNavigationView;
  @BindView(R.id.fragment_container) FrameLayout container;

  @Override public void init(Bundle savedState) {
    ActivityUtil.makeViewRotate(getnContext(), toolbarImage);
    setBottomNavigationClick(bottomNavigationView);
  }

  @Override public int layoutResource() {
    return R.layout.main_activity;
  }

  @Override public void setUpToolbar() {
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }
  }

  private void setBottomNavigationClick(final BottomNavigationView bnv) {
    bnv.setSelectedItemId(R.id.home);
    FragmentUtils.showFragmentOnActivity(getnContext(), HomeFragment.getInstance(),
        R.id.fragment_container, true);
    bnv.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
              case R.id.home:

                FragmentUtils.showFragmentOnActivity(getnContext(), HomeFragment.getInstance(),
                    R.id.fragment_container, true);
                return true;

              case R.id.favorite:
                FragmentUtils.showFragmentOnActivity(getnContext(), FavoriteFragment.getInstance(),
                    R.id.fragment_container, true);
                return true;

              case R.id.search:
                FragmentUtils.showFragmentOnActivity(getnContext(), SearchFragment.getInstance(),
                    R.id.fragment_container, true);
                return true;

              default:
                return false;
            }
          }
        });
  }
}
