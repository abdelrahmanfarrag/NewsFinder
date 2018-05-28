package com.example.mana.newsfinder.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CommonUtils {

  public static String convertDateToString(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("LLLL MM ,yyyy", Locale.US);
    String dat = sdf.format(date);
    return dat;
  }

  public static void RecyclerConfiguration(Context ctx, RecyclerView view) {
    view.setLayoutManager(new LinearLayoutManager(ctx));
    view.addItemDecoration(new DividerItemDecoration(ctx, DividerItemDecoration.VERTICAL));
    view.setHasFixedSize(true);
  }

  public static void alertDialogBuild(Context ctx, String title, String content) {
    new SweetAlertDialog(ctx, SweetAlertDialog.SUCCESS_TYPE)
        .setTitleText(title)
        .setContentText(content)
        .show();
  }

  public static void AutoCompleteAdapter(AppCompatAutoCompleteTextView txtAuto,
      ArrayAdapter<?> adapter) {
    txtAuto.setAdapter(adapter);
    txtAuto.setThreshold(1);
  }

  public static void sharedPrefSetter(Context ctx, String key, String value) {
    SharedPreferences.Editor SP = ctx.getSharedPreferences("data", Context.MODE_PRIVATE).edit();
    SP.putString(key, value);
    SP.apply();
  }

  public static String getSharedPrefs(Context ctx, String key) {
    SharedPreferences sharedPreferences = ctx.getSharedPreferences("data", Context.MODE_PRIVATE);
    String value = sharedPreferences.getString(key, "null");
    return value;
  }
  public static void clearPrefs(Context ctx){
    SharedPreferences.Editor clear = ctx.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
    clear.clear();


  }

}
