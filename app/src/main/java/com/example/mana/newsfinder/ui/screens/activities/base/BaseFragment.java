package com.example.mana.newsfinder.ui.screens.activities.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

  private FragmentActivity fragContext;
  private Unbinder unbinder;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return setUpFragment(inflater, container);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    init(savedInstanceState);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (unbinder != null) {
      unbinder.unbind();
    }
  }

  private View setUpFragment(LayoutInflater inf, ViewGroup container) {
    View view = inf.inflate(setFragmentLayout(), container, false);
    unbinder = ButterKnife.bind(this, view);
    this.fragContext = (FragmentActivity) view.getContext();
    return view;
  }

  public FragmentActivity getFragContext() {
    return fragContext;
  }

  protected abstract @LayoutRes int setFragmentLayout();

  protected abstract void init(Bundle savedState);
}
