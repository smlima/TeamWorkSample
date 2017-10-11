package com.slima.teamworksample.core.views.adapters;

import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergio.lima on 11/10/2017.
 */

public class ListWrapper<T extends ItemViewModel<K>, K>  {

    private List<T> mWrapperList;

    public ListWrapper(List<K> innerValuesList, ViewModelFactory viewModelFactory) {

        mWrapperList = new ArrayList<>(innerValuesList.size());
        for (K k : innerValuesList) {
            mWrapperList.add((T) viewModelFactory.createNewViewModelWithInnerObject(k));
        }
    }

    public List<T> getWrapperList() {
        return mWrapperList;
    }
}
