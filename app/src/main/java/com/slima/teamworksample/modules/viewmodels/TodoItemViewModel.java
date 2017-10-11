package com.slima.teamworksample.modules.viewmodels;

import android.databinding.Bindable;

import com.slima.teamworksample.core.models.TodoItem;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class TodoItemViewModel extends ItemViewModel<TodoItem> {

    public TodoItemViewModel() {
    }

    public TodoItemViewModel(TodoItem task) {
       super(task);
    }

    @Bindable
    public String getContent(){
        return getItem().content;
    }

    @Bindable
    public String getDescription(){
        return getItem().description;
    }

    @Bindable
    public String getDueDate(){
        return getItem().dueDate;
    }
}
