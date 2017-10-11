package com.slima.teamworksample.core.viewmodels.components;

import android.databinding.Bindable;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.viewmodels.BaseViewModel;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class BaseComponentViewModel<T extends UIBaseComponent> extends BaseViewModel {

    protected static final String TAG = "ViewModels";

    private T mBaseComponent;

    private boolean isLoading = false;

    public BaseComponentViewModel() {
        super();
        //IoC.inject(this);
    }

    public void setBaseComponent(T baseComponent) {
        mBaseComponent = baseComponent;
    }

    protected  T getBaseComponent(){
        return mBaseComponent;
    }

    @Override
    public BaseComponentViewModel clone() throws CloneNotSupportedException {
        return (BaseComponentViewModel) super.clone();
    }

    @Bindable
    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
