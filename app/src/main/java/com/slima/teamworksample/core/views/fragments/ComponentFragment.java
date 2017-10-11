package com.slima.teamworksample.core.views.fragments;

import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class ComponentFragment<T extends BaseComponentViewModel> extends BaseFragment {

    private UIBaseComponent mBaseComponent;

    public void setBaseComponent(UIBaseComponent baseComponent) {
        mBaseComponent = baseComponent;
    }

    T mViewModel;

    public T getViewModel() {
        if(mViewModel == null || mBaseComponent.refreshViewModel()) {
            mViewModel = getUIComponentViewModel(mBaseComponent);

        }
        return mViewModel;
    }
}
