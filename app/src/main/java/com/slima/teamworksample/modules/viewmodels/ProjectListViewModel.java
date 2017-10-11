package com.slima.teamworksample.modules.viewmodels;

import com.slima.teamworksample.BR;
import com.slima.teamworksample.R;
import com.slima.teamworksample.core.models.Project;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.components.BaseListComponentViewModel;
import com.slima.teamworksample.core.views.adapters.ListWrapper;
import com.slima.teamworksample.modules.components.ProjectListComponent;
import com.slima.teamworksample.modules.components.TaskListComponent;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ProjectListViewModel extends BaseListComponentViewModel<ProjectListComponent, ProjectViewModel> {

    private final NetworkService mNetworkService;
    private final NavigationService mNavigationService;
    private final ViewModelFactory mViewModelFactory;


    public ProjectListViewModel(NetworkService networkService, NavigationService navigationService, ViewModelFactory viewModelFactory) {
        mNetworkService = networkService;
        mNavigationService = navigationService;
        mViewModelFactory = viewModelFactory;
    }

    @Override
    public void setBaseComponent(ProjectListComponent baseComponent) {
        super.setBaseComponent(baseComponent);

        mNetworkService.getAllProjects(new RepositoryCallback<List<Project>>() {
            @Override
            public void onSuccess(List<Project> value) {
                setListItems(new ListWrapper<ProjectViewModel, Project>(value, mViewModelFactory));
            }

            @Override
            public void onError(Throwable throwable) {
                // NOP
            }
        });
    }


    public OnItemBind<ProjectViewModel> getItemBinding() {
        // TODO: simplify....
        return new OnItemBind<ProjectViewModel>() {
            @Override
            public void onItemBind(ItemBinding itemBinding, int position, ProjectViewModel item) {
                itemBinding.set(BR.vm, R.layout.project_list_item);
                itemBinding.bindExtra(BR.listener, getItemClickListener());

            }
        };
    }


    public interface OnItemClickListener {
        void onItemClick(Project item);
    }

    private OnItemClickListener getItemClickListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(Project item) {

                TaskListComponent taskListComponent = new TaskListComponent();
                taskListComponent.setProjectId(item.id);
                taskListComponent.setRefreshViewModel(true);

                mNavigationService.openInnerComponent(taskListComponent);

            }
        };
    }

}
