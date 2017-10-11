package com.slima.teamworksample.core.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.viewmodels.components.BaseListComponentViewModel;
import com.slima.teamworksample.databinding.CommonListFragmentBinding;

/**
 * Created by sergio.lima on 11/10/2017.
 */

public class ListComponentFragment<T extends BaseListComponentViewModel> extends ComponentFragment<T> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CommonListFragmentBinding inflate = DataBindingUtil.inflate(inflater, R.layout.common_list_fragment, container, false);
        inflate.setVm(getViewModel());

        return inflate.getRoot();

    }
}
