package com.slima.teamworksample.core.services;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.views.fragments.BaseFragment;
import com.slima.teamworksample.modules.views.fragments.AccountDetailsFragment;
import com.slima.teamworksample.modules.views.fragments.AddQuickTaskFragment;
import com.slima.teamworksample.modules.views.fragments.ProjectListFragment;
import com.slima.teamworksample.modules.views.fragments.ProjectTaskListFragment;
import com.slima.teamworksample.modules.views.fragments.TaskListFragment;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class ViewFactory {

    @Inject
    public ViewFactory() {
        createMap();
    }

    private Map<ComponentType, BaseFragment> mFragmentMap = new HashMap<>();

    private void createMap() {

        mFragmentMap.put(ComponentType.ACCOUNT_DETAILS, new AccountDetailsFragment());
        mFragmentMap.put(ComponentType.PROJECT_LIST, new ProjectListFragment());
        mFragmentMap.put(ComponentType.PROJECT_TASKS_LIST, new ProjectTaskListFragment());
        mFragmentMap.put(ComponentType.ADD_QUICK_TASK, new AddQuickTaskFragment());
        mFragmentMap.put(ComponentType.TASKLIST, new TaskListFragment());

    }

    public BaseFragment getFragmentForComponent(UIBaseComponent baseComponent){

        BaseFragment baseFragment = getFragmentForComponent(baseComponent.getComponentType());
        baseFragment.setBaseComponent(baseComponent);
        return baseFragment;

    }

    public BaseFragment getFragmentForComponent(ComponentType componentTypes){
        return mFragmentMap.get(componentTypes);
    }
}
