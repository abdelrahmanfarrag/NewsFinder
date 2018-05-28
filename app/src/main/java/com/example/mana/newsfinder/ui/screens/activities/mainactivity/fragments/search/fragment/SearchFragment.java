package com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.fragment;

import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import butterknife.BindView;
import com.example.mana.newsfinder.R;
import com.example.mana.newsfinder.data.model.category_search;
import com.example.mana.newsfinder.data.model.country_search;
import com.example.mana.newsfinder.data.model.news;
import com.example.mana.newsfinder.data.model.source_search;
import com.example.mana.newsfinder.ui.screens.activities.base.BaseFragment;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.adapters.SearchAdapter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.presenter.SearchFragmentPresenter;
import com.example.mana.newsfinder.ui.screens.activities.mainactivity.fragments.search.presenter.view_searchFragment;
import com.example.mana.newsfinder.utilities.CommonUtils;
import java.util.List;

public class SearchFragment extends BaseFragment implements view_searchFragment {

  @BindView(R.id.autocomplete_source) AppCompatAutoCompleteTextView sourceTxt;
  @BindView(R.id.autocomplete_country) AppCompatAutoCompleteTextView countryTxt;
  @BindView(R.id.autocomplete_type) AppCompatAutoCompleteTextView categoryTxt;
  @BindView(R.id.search_list) RecyclerView searchList;
  @BindView(R.id.search_btn) Button searchBtn;

  SearchFragmentPresenter presenter;

  public static SearchFragment getInstance() {
    return new SearchFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.search_fragment;
  }

  @Override protected void init(final Bundle savedState) {

    presenter = new SearchFragmentPresenter(getFragContext(), this);
    setUpCategorySearch(categoryTxt);
    setUpCountrySearch(countryTxt);
    setUpSourceSearch(sourceTxt);
    sourceTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        source_search search = (source_search) parent.getItemAtPosition(position);
        CommonUtils.sharedPrefSetter(getFragContext(), "source", search.getValue());
      }
    });

    countryTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        country_search search = (country_search) parent.getItemAtPosition(position);
        CommonUtils.sharedPrefSetter(getFragContext(), "country", search.getValue());
      }
    });

    categoryTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        category_search search = (category_search) parent.getItemAtPosition(position);
        CommonUtils.sharedPrefSetter(getFragContext(), "category", search.getValue());
      }
    });

    CommonUtils.RecyclerConfiguration(getFragContext(), searchList);
    searchBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        searchList.setAdapter(null);
        String country = CommonUtils.getSharedPrefs(getFragContext(), "country");
        String category = CommonUtils.getSharedPrefs(getFragContext(), "category");
        String source = CommonUtils.getSharedPrefs(getFragContext(), "source");
        presenter.LoadTopics(country, category, source);
        CommonUtils.clearPrefs(getFragContext());
      }
    });
  }

  private void setUpCategorySearch(AppCompatAutoCompleteTextView txt) {
    ArrayAdapter<category_search> ca_adapter =
        new ArrayAdapter(getFragContext(), android.R.layout.simple_dropdown_item_1line,
            presenter.getCategoryList());
    CommonUtils.AutoCompleteAdapter(txt, ca_adapter);
  }

  private void setUpCountrySearch(AppCompatAutoCompleteTextView txt) {
    ArrayAdapter<country_search> c_adapter =
        new ArrayAdapter(getFragContext(), android.R.layout.simple_dropdown_item_1line,
            presenter.getCountryList());
    CommonUtils.AutoCompleteAdapter(txt, c_adapter);
  }

  private void setUpSourceSearch(AppCompatAutoCompleteTextView txt) {
    ArrayAdapter<country_search> c_adapter =
        new ArrayAdapter(getFragContext(), android.R.layout.simple_dropdown_item_1line,
            presenter.getSourceList());
    CommonUtils.AutoCompleteAdapter(txt, c_adapter);
  }

  @Override public void setSearchList(List<news.articles> articles) {
    searchList.setAdapter(new SearchAdapter(articles));

  }
}
