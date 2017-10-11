package com.slima.teamworksample.core.services;

import android.util.Log;

import com.slima.teamworksample.core.components.ComponentType;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.models.Project;
import com.slima.teamworksample.core.models.Tasklist;
import com.slima.teamworksample.core.models.TodoItem;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;
import com.slima.teamworksample.modules.viewmodels.AccountDetailsViewModel;
import com.slima.teamworksample.modules.viewmodels.AddQuickTaskViewModel;
import com.slima.teamworksample.modules.viewmodels.ProjectListViewModel;
import com.slima.teamworksample.modules.viewmodels.ProjectTodoItemListViewModel;
import com.slima.teamworksample.modules.viewmodels.ProjectViewModel;
import com.slima.teamworksample.modules.viewmodels.TaskListViewModel;
import com.slima.teamworksample.modules.viewmodels.TaskListsViewModel;
import com.slima.teamworksample.modules.viewmodels.TodoItemViewModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * Created by sergio.lima on 07/10/2017.
 */
@Reusable
public class ViewModelFactory {

    private static final String TAG = "ViewModelFactory";

    private Map<ComponentType, BaseComponentViewModel> mViewModelMap;

    final ResourcesService mResourcesService;
    final NavigationService mNavigationService;
    final NetworkService mNetworkService;

    @Inject
    public ViewModelFactory(ResourcesService resourcesService, NavigationService navigationService, NetworkService networkService) {
        mResourcesService = resourcesService;
        mNavigationService = navigationService;
        mNetworkService = networkService;

        createMap();
    }

    private void createMap() {
        mViewModelMap = new HashMap<>();

        // empty models.. .ready for cloning and use...
        mViewModelMap.put(ComponentType.ACCOUNT_DETAILS, new AccountDetailsViewModel(mNetworkService));
        mViewModelMap.put(ComponentType.PROJECT_LIST, new ProjectListViewModel(mNetworkService, mNavigationService, this));
        mViewModelMap.put(ComponentType.PROJECT_TASKS_LIST, new ProjectTodoItemListViewModel(mNetworkService, mNavigationService, this));
        mViewModelMap.put(ComponentType.ADD_QUICK_TASK, new AddQuickTaskViewModel(mNetworkService, mNavigationService));
        mViewModelMap.put(ComponentType.TASKLIST, new TaskListViewModel(mNetworkService, mNavigationService, this));
    }


    public  <T extends BaseComponentViewModel> T createViewModelForComponent(UIBaseComponent component){

        if (component != null){

            BaseComponentViewModel baseComponentViewModel = mViewModelMap.get(component.getComponentType());
            try {
                BaseComponentViewModel clone = baseComponentViewModel.clone();
                clone.setBaseComponent(component);
                return (T) clone;
            } catch (CloneNotSupportedException e){
                // FIXME: should throw instead...
                Log.e(TAG, "Cannot clone the VM. ", e);
                return null;
            } catch (Exception e){
                // FIXME: should throw instead...
                Log.e(TAG, "Error ... make sure the ViewModel is on the MAP... ", e);
                return null;
            }

        }

        //FIXME: it would be better to throw an exception at this point. If there's no component there's no point continuing
        return null;
    }

    public <T extends ItemViewModel<K>, K > T createNewViewModelWithInnerObject(K k) {

        if (k instanceof Project){
            ItemViewModel projectViewModel = new ProjectViewModel();
            projectViewModel.setItem(k);
            return (T) projectViewModel;
        }
        if (k instanceof Tasklist){
            ItemViewModel projectViewModel = new TaskListsViewModel();
            projectViewModel.setItem(k);
            return (T) projectViewModel;
        }
        if (k instanceof TodoItem){
            ItemViewModel projectViewModel = new TodoItemViewModel();
            projectViewModel.setItem(k);
            return (T) projectViewModel;
        }

        return null;
    }
}
