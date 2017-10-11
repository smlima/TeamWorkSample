package com.slima.teamworksample.modules.viewmodels;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.R;
import com.slima.teamworksample.core.models.TodoItem;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.components.BaseListComponentViewModel;
import com.slima.teamworksample.core.views.adapters.ListWrapper;
import com.slima.teamworksample.modules.components.ProjectTasksListComponent;
import com.slima.teamworksample.modules.components.TaskComponent;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ProjectTodoItemListViewModel extends BaseListComponentViewModel<ProjectTasksListComponent, TodoItemViewModel> {

    private final NetworkService mNetworkService;
    private final NavigationService mNavigationService;
    private final ViewModelFactory mViewModelFactory;

    public ProjectTodoItemListViewModel(NetworkService networkService, NavigationService navigationService, ViewModelFactory viewModelFactory) {
        mNetworkService = networkService;
        mNavigationService = navigationService;
        mViewModelFactory = viewModelFactory;
    }

    @Override
    public void setBaseComponent(ProjectTasksListComponent baseComponent) {
        super.setBaseComponent(baseComponent);

        RepositoryCallback<List<TodoItem>> repositoryCallback = new RepositoryCallback<List<TodoItem>>() {
            @Override
            public void onSuccess(List<TodoItem> value) {
                setListItems(new ListWrapper<TodoItemViewModel, TodoItem>(value, mViewModelFactory));
            }

            @Override
            public void onError(Throwable throwable) {
                // NOP
            }
        };
        if (baseComponent.getProjectId() != null ) {
            mNetworkService.getTasksPerProject(baseComponent.getProjectId(), repositoryCallback);
        } else {
            mNetworkService.getAllMyTasksBlocking(repositoryCallback);
        }
    }

    public OnItemBind<TodoItemViewModel> getItemBinding() {
        // TODO: simplify....
        return new OnItemBind<TodoItemViewModel>() {
            @Override
            public void onItemBind(ItemBinding itemBinding, int position, TodoItemViewModel item) {
                itemBinding.set(BR.vm, R.layout.todoitem_list_item);
            }
        };
    }

    interface onTaskClickListener{
        void onClick(TodoItem task);
    }

    private ProjectTodoItemListViewModel.onTaskClickListener getTaskClickListener() {
        return new ProjectTodoItemListViewModel.onTaskClickListener() {
            @Override
            public void onClick(TodoItem task) {

                TaskComponent componentTypes = new TaskComponent();
                componentTypes.setTask(task);

                mNavigationService.openInnerComponent(componentTypes);

            }
        };
    }
}
