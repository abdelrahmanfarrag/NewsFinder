package com.example.mana.newsfinder.ui.screens.activities.splash.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseActivity;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.activity.MainActivity;
import com.example.mana.newsfinder.utilities.ActivityUtil;
import java.util.List;

public class SplashActivity extends BaseActivity {

  @BindView(R.id.splash_img) ImageView splashImage;

  @Override public void init(Bundle savedState) {
    ActivityUtil.makeViewRotate(getnContext(), splashImage);
    setIntent();
    List<news.articles> list = getIntent().getParcelableArrayListExtra("data");
    if (list!=null){
      Toast.makeText(getnContext(),String.valueOf(list.size()),Toast.LENGTH_LONG).show();
    }else {
      Toast.makeText(getnContext(),"Your list is null",Toast.LENGTH_LONG).show();
    }
  }

  @Override public int layoutResource() {
    return R.layout.splash_activity;
  }

  @Override public void setUpToolbar() {

  }

  private void setIntent() {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
      @Override public void run() {
        ActivityUtil.Intent(getnContext(), MainActivity.class);
      }
    };
    handler.postDelayed(runnable, 5000);
  }
}
