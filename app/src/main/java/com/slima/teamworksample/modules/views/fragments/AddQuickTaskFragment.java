package com.slima.teamworksample.modules.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.views.fragments.ComponentFragment;
import com.slima.teamworksample.databinding .AddQuickTaskFragmentBinding;
import com.slima.teamworksample.modules.viewmodels.AddQuickTaskViewModel;


/**
 * Created by sergio.lima on 10/10/2017.
 */

public class AddQuickTaskFragment extends ComponentFragment<AddQuickTaskViewModel> {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AddQuickTaskFragmentBinding inflate = DataBindingUtil.inflate(inflater, R.layout.add_quick_task_fragment, container, false);
        inflate.setVm(getViewModel());


        return inflate.getRoot();
    }
}
