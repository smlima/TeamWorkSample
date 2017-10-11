package com.slima.teamworksample.core.viewmodels.pages;

import android.databinding.Bindable;

import com.slima.teamworksample.core.components.ui.UIPageComponent;
import com.slima.teamworksample.core.viewmodels.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class PageViewModel extends BaseViewModel {

    private String mTitle;

    private UIPageComponent mPageComponent;

    @Inject
    public PageViewModel() {
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UIPageComponent getPageComponent() {
        return mPageComponent;
    }

    public void setPageComponent(UIPageComponent pageComponent) {
        mPageComponent = pageComponent;
    }

    @Bindable
    public boolean isShowActionBar(){
        return mPageComponent.isShowActionBar();
    }
}