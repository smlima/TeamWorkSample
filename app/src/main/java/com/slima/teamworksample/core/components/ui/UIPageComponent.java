package com.slima.teamworksample.core.components.ui;

import com.slima.teamworksample.core.components.BaseComponent;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public abstract class UIPageComponent extends BaseComponent{

    private String mPageTitle;

    // the page need to have at least one component
    private UIBaseComponent mTopComponent;

    public UIPageComponent() {
    }

    public String getPageTitle() {
        return mPageTitle;
    }

    public void setPageTitle(String pageTitle) {
        mPageTitle = pageTitle;
    }

    public UIBaseComponent getTopComponent() {
        return mTopComponent;
    }

    public void setTopComponent(UIBaseComponent topComponent) {
        mTopComponent = topComponent;
    }

    public boolean isShowActionBar(){
        return mTopComponent.isShowActionBar();
    }
}
