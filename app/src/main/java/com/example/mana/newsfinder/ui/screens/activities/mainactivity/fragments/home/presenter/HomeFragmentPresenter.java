package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.home.presenter;

import android.content.Context;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.utilities.retrofitUtils.RetrofitUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter {
  private Context ctx;
  private view_homeFragment view;

  public HomeFragmentPresenter(Context ctx,view_homeFragment view) {
    this.view = view;
    this.ctx = ctx;
  }

  public void getArticles() {
    Map map = new HashMap<>();
    map.put("country", "us");
    map.put("apiKey", RetrofitUtil.API_KEY);
    RetrofitUtil.getInterfaceService().getArticles(map).enqueue(new Callback<ResponseBody>() {

      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
         List<news.articles> articleList= RetrofitUtil.response(response.body().string());
          view.getNews(articleList);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {

      }
    });
  }
}
