package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.example.mana.newsfinder.data.model.category_search;
import com.example.mana.newsfinder.data.model.country_search;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.data.model.source_search;
import com.example.mana.newsfinder.utilities.CommonUtils;
import com.example.mana.newsfinder.utilities.retrofitUtils.RetrofitUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragmentPresenter {
  Context ctx;
  view_searchFragment view_searchFragment;

  public SearchFragmentPresenter(Context ctx, view_searchFragment view_searchFragment) {
    this.ctx = ctx;
    this.view_searchFragment = view_searchFragment;
  }

  public List<country_search> getCountryList() {
    List<country_search> countryList = new ArrayList<>();
    countryList.add(new country_search("Argentina", "ar"));
    countryList.add(new country_search("Australia", "au"));
    countryList.add(new country_search("Austria", "at"));
    countryList.add(new country_search("Belgium", "be"));
    countryList.add(new country_search("Brazil", "br"));
    countryList.add(new country_search("Bulgaria", "bg"));
    countryList.add(new country_search("Canada", "ca"));
    countryList.add(new country_search("China", "cn"));
    countryList.add(new country_search("Colombia", "co"));
    countryList.add(new country_search("Cuba", "cu"));
    countryList.add(new country_search("Czech Republic", "cz"));
    countryList.add(new country_search("Egypt", "eg"));
    countryList.add(new country_search("France", "fr"));
    countryList.add(new country_search("Germany", "de"));
    countryList.add(new country_search("Greece", "gr"));
    countryList.add(new country_search("Hong Kong", "hk"));
    countryList.add(new country_search("Hungary", "hu"));
    countryList.add(new country_search("India", "in"));
    countryList.add(new country_search("Indonesia", "id"));
    countryList.add(new country_search("Ireland", "ir"));
    countryList.add(new country_search("Israel", "il"));
    countryList.add(new country_search("Italy", "it"));
    countryList.add(new country_search("Japan", "jp"));
    countryList.add(new country_search("Mexico", "mx"));
    countryList.add(new country_search("Morocco", "mo"));
    countryList.add(new country_search("Netherlands", "nl"));
    countryList.add(new country_search("News Zealand", "nz"));
    countryList.add(new country_search("Nigeria", "ng"));
    countryList.add(new country_search("Poland", "pl"));
    countryList.add(new country_search("Portugal", "pt"));
    countryList.add(new country_search("Russia", "ru"));
    countryList.add(new country_search("Saudi Arabia", "sa"));
    countryList.add(new country_search("Turkey", "tr"));
    countryList.add(new country_search("Switzerland", "ch"));
    countryList.add(new country_search("South Korea", "kr"));
    countryList.add(new country_search("United Kingdom", "gb"));
    countryList.add(new country_search("USA", "us"));
    countryList.add(new country_search("UAE", "ae"));

    return countryList;
  }

  public List<source_search> getSourceList() {
    List<source_search> sourceList = new ArrayList<>();
    sourceList.add(new source_search("ABC News", "abc-news"));
    sourceList.add(new source_search("Al Jazeera English", "al-jazeera-english"));
    sourceList.add(new source_search("Argaam", "argaam"));
    sourceList.add(new source_search("BBC News", "bbc-news"));
    sourceList.add(new source_search("BBC Sport", "bbc-sport"));
    sourceList.add(new source_search("Bleacher Report", "bleacher-report"));
    sourceList.add(new source_search("CNN", "cnn"));
    sourceList.add(new source_search("Daily Mail", "daily-mail"));
    sourceList.add(new source_search("ESPN", "espn"));
    sourceList.add(new source_search("Financial Post", "financial-post"));
    sourceList.add(new source_search("Fox News", "fox-news"));
    sourceList.add(new source_search("Google News", "google-news"));
    sourceList.add(new source_search("Independent", "independent"));
    sourceList.add(new source_search("L'equipe", "lequipe"));
    sourceList.add(new source_search("Marca", "marca"));
    sourceList.add(new source_search("National Geographic", "national-geographic"));
    sourceList.add(new source_search("Reuters", "reuters"));
    sourceList.add(new source_search("RT", "rt"));
    sourceList.add(new source_search("The Guardian (UK)", "the-guardian-uk"));
    sourceList.add(new source_search("The Telegraph", "the-telegraph"));
    sourceList.add(new source_search("The Washington Post", "the-washington-post"));
    sourceList.add(new source_search("Time", "time"));
    return sourceList;
  }

  public List<category_search> getCategoryList() {
    List<category_search> categoryList = new ArrayList<>();
    categoryList.add(new category_search("Science", "science"));
    categoryList.add(new category_search("Health", "health"));
    categoryList.add(new category_search("Sports", "sports"));
    categoryList.add(new category_search("Entertainment", "entertainment"));
    categoryList.add(new category_search("Technology", "technology"));
    categoryList.add(new category_search("Business", "business"));
    return categoryList;
  }

  public void LoadTopics(String country, String category, String source) {
    Map params = new HashMap();
    params.put("country", country);
    params.put("category", category);
    params.put("source", source);
    params.put("apiKey", RetrofitUtil.API_KEY);
    RetrofitUtil.getInterfaceService().getArticles(params).enqueue(new Callback<ResponseBody>() {

      @Override public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
          List<news.articles> result = RetrofitUtil.response(response.body().string());
          view_searchFragment.setSearchList(result);
        } catch (IOException e) {
          Log.i("resp", "check");
        }
      }

      @Override public void onFailure(Call<ResponseBody> call, Throwable t) {

      }
    });
  }
}
