package com.example.mana.newsfinder.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.mana.newsfinder.R;

public class ActivityUtil {

  public static void setActivityAnimated(Activity activity) {
    activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
  }

  public static void makeViewRotate(Context nContext, View v) {
    Animation animation = AnimationUtils.loadAnimation(nContext, R.anim.rotate);
    v.startAnimation(animation);
  }

  public static void Intent(Context nContext, Class<?> destination) {
    nContext.startActivity(new Intent(nContext, destination));
  }

  public static void IntentExtra(Context nContext, Intent intent) {
    nContext.startActivity(intent);
  }
}
