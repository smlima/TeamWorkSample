package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ProjectTasksListComponent extends UIBaseComponent {

    private String mProjectId;

    @Override
    public String getTitle() {
        return "List Tasks";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.PROJECT_TASKS_LIST;
    }

    public void setProjectId(String projectId) {
        mProjectId = projectId;
    }

    public String getProjectId() {
        return mProjectId;
    }
}
