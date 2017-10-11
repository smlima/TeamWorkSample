package com.slima.teamworksample.core.components.ui;

import com.slima.teamworksample.core.components.ComponentType;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public abstract class UIBaseComponent  {

    private boolean mRefreshViewModel = false;

    private boolean mShowActionBar = true;
    public abstract String getTitle();

    public abstract ComponentType getComponentType();

    public boolean isShowActionBar() {
        return mShowActionBar;
    }

    public void setShowActionBar(boolean showActionBar) {
        mShowActionBar = showActionBar;
    }

    public void setRefreshViewModel(boolean refreshViewModel) {
        mRefreshViewModel = refreshViewModel;
    }

    public boolean refreshViewModel(){
        return mRefreshViewModel;
    }
}
