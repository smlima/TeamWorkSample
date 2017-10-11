package com.slima.teamworksample.modules.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.views.fragments.ComponentFragment;
import com.slima.teamworksample.databinding.AccountDetailsFragmentBinding;
import com.slima.teamworksample.modules.viewmodels.AccountDetailsViewModel;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class AccountDetailsFragment extends ComponentFragment<AccountDetailsViewModel> {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AccountDetailsFragmentBinding inflate = DataBindingUtil.inflate(inflater, R.layout.account_details_fragment, container, false);
        inflate.setVm(getViewModel());


        return inflate.getRoot();
    }
}
