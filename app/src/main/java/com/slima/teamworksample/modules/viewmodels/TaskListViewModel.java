package com.slima.teamworksample.modules.viewmodels;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.R;
import com.slima.teamworksample.core.models.Tasklist;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.components.BaseListComponentViewModel;
import com.slima.teamworksample.core.views.adapters.ListWrapper;
import com.slima.teamworksample.modules.components.AddQuickTaskComponent;
import com.slima.teamworksample.modules.components.ProjectTasksListComponent;
import com.slima.teamworksample.modules.components.TaskListComponent;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class TaskListViewModel extends BaseListComponentViewModel<TaskListComponent, TaskListsViewModel> {

    private final NetworkService mNetworkService;
    private final NavigationService mNavigationService;
    private final ViewModelFactory mViewModelFactory;

    public TaskListViewModel(NetworkService networkService, NavigationService navigationService, ViewModelFactory viewModelFactory) {
        mNetworkService = networkService;
        mNavigationService = navigationService;
        mViewModelFactory = viewModelFactory;
    }

    @Override
    public void setBaseComponent(TaskListComponent baseComponent) {
        super.setBaseComponent(baseComponent);

        mNetworkService.getTaskListPerProject(baseComponent.getProjectId(), new RepositoryCallback<List<Tasklist>>() {
            @Override
            public void onSuccess(List<Tasklist> value) {
                setListItems(new ListWrapper<TaskListsViewModel, Tasklist>(value, mViewModelFactory));

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public OnItemBind<TaskListsViewModel> getItemBinding() {
        // TODO: simplify....
        return new OnItemBind<TaskListsViewModel>() {
            @Override
            public void onItemBind(ItemBinding itemBinding, int position, TaskListsViewModel item) {
                itemBinding.set(BR.vm, R.layout.tasklist_list_item);
                itemBinding.bindExtra(BR.listener, getItemClickListener());

            }
        };
    }


    public interface OnItemClickListener {
        void onAddItemClick(Tasklist item);
        void onSearchItemClick(Tasklist item);
    }

    private OnItemClickListener getItemClickListener() {
        return new OnItemClickListener() {

            @Override
            public void onAddItemClick(Tasklist item) {
                AddQuickTaskComponent addQuickTaskComponent = new AddQuickTaskComponent();
                addQuickTaskComponent.setProjectId(getBaseComponent().getProjectId());
                addQuickTaskComponent.setTasklistId(item.id);
                addQuickTaskComponent.setRefreshViewModel(true);

                mNavigationService.openInnerComponent(addQuickTaskComponent);
            }

            @Override
            public void onSearchItemClick(Tasklist item) {
                ProjectTasksListComponent taskListComponent = new ProjectTasksListComponent();
                taskListComponent.setProjectId(getBaseComponent().getProjectId());
                taskListComponent.setRefreshViewModel(true);

                mNavigationService.openInnerComponent(taskListComponent);
            }
        };
    }

}
