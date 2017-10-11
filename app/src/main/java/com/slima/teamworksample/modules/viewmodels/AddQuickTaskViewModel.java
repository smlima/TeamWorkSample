package com.slima.teamworksample.modules.viewmodels;

import android.util.Log;
import android.widget.Toast;

import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.core.models.PostResult;
import com.slima.teamworksample.core.models.QuickAddTask;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;
import com.slima.teamworksample.modules.components.AddQuickTaskComponent;

/**
 * Created by sergio.lima on 10/10/2017.
 */

public class AddQuickTaskViewModel extends BaseComponentViewModel<AddQuickTaskComponent> {

    private final NetworkService mNetworkService;
    private final NavigationService mNavigationService;
    private String mName;
    private String mDescription;

    public AddQuickTaskViewModel(NetworkService networkService, NavigationService navigationService) {
        mNetworkService = networkService;
        mNavigationService = navigationService;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void onSaveClicked(){
        Log.d("SLIMA", "SAVE..." + mName + " , " + mDescription);

        QuickAddTask quickAddTask = new QuickAddTask();
        quickAddTask.content = mDescription;
        quickAddTask.tasklistId = Integer.parseInt(getBaseComponent().getTasklistId());

        setLoading(true);
        mNetworkService.addQuickTask(quickAddTask, new RepositoryCallback<PostResult>() {
            @Override
            public void onSuccess(PostResult value) {
                Toast.makeText(TeamWorkSampleApplication.getInstance(), "Successfuly added!!", Toast.LENGTH_LONG).show();
                setLoading(false);
            }

            @Override
            public void onError(Throwable throwable) {
                Toast.makeText(TeamWorkSampleApplication.getInstance(), "Error adding task!!", Toast.LENGTH_LONG).show();

                setLoading(false);
            }
        });
    }

    public void onCancelClicked(){
        Log.d("SLIMA", "Cancel...");
        mNavigationService.back();
    }
}
