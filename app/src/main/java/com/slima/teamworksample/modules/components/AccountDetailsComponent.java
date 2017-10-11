package com.slima.teamworksample.modules.components;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class AccountDetailsComponent extends UIBaseComponent {
    @Override
    public String getTitle() {
        return "Account Details";
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.ACCOUNT_DETAILS;
    }
}
