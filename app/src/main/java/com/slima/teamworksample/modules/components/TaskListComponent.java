package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class TaskListComponent extends UIBaseComponent{

    private String mProjectId;

    @Override
    public String getTitle() {
        return "TaskList";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.TASKLIST;
    }

    public String getProjectId() {
        return mProjectId;
    }

    public void setProjectId(String projectId) {
        mProjectId = projectId;
    }
}
