package com.slima.teamworksample.core.services;

import android.content.Context;

import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.views.activities.BaseActivity;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class NavigationService {

    private final Context mAppContext;

    @Inject
    ViewFactory mViewFactory;

    BaseActivity mLastActivity;

    @Inject
    public NavigationService(Context context) {
        mAppContext = context;
    }

    public void openInnerComponent(UIBaseComponent componentTypes){
        mLastActivity.openInnerComponent(componentTypes);
    }

    public void updateLastActivity(BaseActivity activity){
        mLastActivity = activity;
    }


    public void back() {
        //FIXME: this could be to return to dashboard/init screen....
        mLastActivity.onBackPressed();
    }
}
