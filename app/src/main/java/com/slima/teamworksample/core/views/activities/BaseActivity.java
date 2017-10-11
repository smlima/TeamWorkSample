package com.slima.teamworksample.core.views.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.R;
import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.application.ioc.TWComponent;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.components.ui.UIPageComponent;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.ResourcesService;
import com.slima.teamworksample.core.services.ViewFactory;
import com.slima.teamworksample.core.viewmodels.pages.PageViewModel;
import com.slima.teamworksample.core.views.fragments.BaseFragment;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Model of the Page itself
     */
    @Inject
    public PageViewModel mPageViewModel;

    @Inject
    ResourcesService mResourcesService;

    @Inject
    ViewFactory mViewFactory;

    @Inject
    NavigationService mNavigationService;


    @Inject
    SharedPreferences mSharedPreferences;

    protected TWComponent mTwComponent;

    public PageViewModel getViewModel() {
        return mPageViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTwComponent = TeamWorkSampleApplication.getInstance().getRootComponent();
        mTwComponent.inject(this);

        mNavigationService.updateLastActivity(this);

    }

    /**
     * Setup common activity stuff
     *
     * @param savedInstanceState
     * @param root
     */
    protected void setupActivity(Bundle savedInstanceState, View root) {
        if (savedInstanceState == null) {
            // initial setup

            setSupportActionBar((Toolbar) root.findViewById(R.id.toolbar_actionBar));

            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //getSupportActionBar().setTitle(mPageViewModel.getTitle());

        }
    }

    protected BaseFragment getTopComponentFragment(UIPageComponent pageComponent) {
        return mViewFactory.getFragmentForComponent(pageComponent.getTopComponent());
    }

    protected void replaceFragment(BaseFragment fragment) {
        if (getFragmentContainerId() != 0) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContainerId(), fragment)
                    .addToBackStack(null)
                    .commit();

            mPageViewModel.notifyPropertyChanged(BR.showActionBar);
            mPageViewModel.notifyPropertyChanged(BR.title);
        } else {
            throw new RuntimeException("The Activity does not support Fragment replacement...");
        }
    }

    abstract @IdRes
    int getFragmentContainerId();

    public void openInnerComponent(UIBaseComponent component) {
        //TODO: apply some animation while switching the fragments around here prob....
        //TODO; anim that could be Component specific...
        mPageViewModel.getPageComponent().setTopComponent(component);
        mPageViewModel.setTitle(component.getTitle());
        BaseFragment fragmentForComponent = mViewFactory.getFragmentForComponent(component);
        replaceFragment(fragmentForComponent);
    }
}