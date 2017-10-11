package com.slima.teamworksample.core.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * Created by sergio.lima on 07/10/2017.
 */
@Reusable
public class BaseFragment extends Fragment {


    private UIBaseComponent mBaseComponent;

    /**
     * set the component to the correct fragment
     * @param baseComponent
     */
    public void setBaseComponent(UIBaseComponent baseComponent) {
        mBaseComponent = baseComponent;
    }

    @Inject
    ViewModelFactory mViewModelFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TeamWorkSampleApplication.getInstance().getRootComponent().inject(this);
    }

    protected <T extends BaseComponentViewModel> T getUIComponentViewModel(UIBaseComponent component){
        return mViewModelFactory.createViewModelForComponent(component);
    }
}
