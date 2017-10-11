package com.slima.teamworksample.core.components.ui;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class SinglePageComponent extends UIPageComponent {

    public SinglePageComponent(UIBaseComponent pageComponent) {
        setTopComponent( pageComponent);
        setPageTitle(getTopComponent().getTitle());
    }
}
