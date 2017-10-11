package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ProjectListComponent extends UIBaseComponent {
    @Override
    public String getTitle() {
        return "Project List";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.PROJECT_LIST;
    }
}
