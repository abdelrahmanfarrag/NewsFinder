package com.example.mana.newsfinder.utilities.retrofitUtils;

import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.utilities.retrofitUtils.InterfaceService;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
  public static final String BASE_URL = "https://newsapi.org/v2/";
  public static final String API_KEY = "8790a66266f6458eb99f6e01101e8442";

  //Instantiate RetrofitBuilder
  public static Retrofit retrofitBuilder() {
    Retrofit retrofit = new Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit;
  }

  //QueryMap
  public static Map<String, String> queryMap(Map<String, String> params) {
    return params;
  }

  //Attach RetrofitBuild to Service
  public static InterfaceService getInterfaceService() {
    InterfaceService interfaceService = retrofitBuilder().create(InterfaceService.class);
    return interfaceService;
  }

  //Convert response from json to readable format !
  public static List<news.articles> response(String resp) {
    Gson gson = new Gson();
    news transformResponse = gson.fromJson(resp, news.class);
    List<news.articles> articles = transformResponse.getListArticles();
    return articles;
  }
}
