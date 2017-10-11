package com.slima.teamworksample.core.views.adapters;

import android.databinding.ViewDataBinding;
import android.util.Log;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ListRecylerViewAdapter<T> extends BindingRecyclerViewAdapter<T> {

    private static final String TAG = "ListRecylerViewAdapter";

    @Override
    public void onBindBinding(ViewDataBinding binding, int bindingVariable, int layoutRes, int position, T item) {
        super.onBindBinding(binding, bindingVariable, layoutRes, position, item);
        Log.d(TAG, "bound binding: " + binding + " at position: " + position);
    }


}
