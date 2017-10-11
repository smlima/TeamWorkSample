package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.models.TodoItem;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class TaskComponent extends UIBaseComponent{
    private TodoItem mTask;

    @Override
    public String getTitle() {
        return "Task Details";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.TASK_DETAILS;
    }

    public void setTask(TodoItem task) {
        mTask = task;
    }

    public TodoItem getTask() {
        return mTask;
    }
}
