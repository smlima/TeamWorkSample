package com.slima.teamworksample.modules.viewmodels;

import android.databinding.Bindable;

import com.slima.teamworksample.core.models.Tasklist;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class TaskListsViewModel extends ItemViewModel<Tasklist> {


    public TaskListsViewModel() {
    }

    public TaskListsViewModel(Tasklist item) {
        super(item);
    }

    @Bindable
    public String getName(){
        return getItem().name;
    }

    @Bindable
    public String getDescription(){
        return getItem().description;
    }


}
