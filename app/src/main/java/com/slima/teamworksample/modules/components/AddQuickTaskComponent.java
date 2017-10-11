package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class AddQuickTaskComponent extends UIBaseComponent{
    private String mProjectId;
    private String mTasklistId;

    @Override
    public String getTitle() {
        return "Add Quick Task";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.ADD_QUICK_TASK;
    }

    public void setProjectId(String projectId) {
        mProjectId = projectId;
    }

    public String getProjectId() {
        return mProjectId;
    }

    public void setTasklistId(String tasklistId) {
        mTasklistId = tasklistId;
    }

    public String getTasklistId() {
        return mTasklistId;
    }
}
