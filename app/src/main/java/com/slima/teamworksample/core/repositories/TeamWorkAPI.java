package com.slima.teamworksample.core.repositories;

import com.slima.teamworksample.core.models.CallAccount;
import com.slima.teamworksample.core.models.CallProjects;
import com.slima.teamworksample.core.models.CallTasks;
import com.slima.teamworksample.core.models.PostResult;
import com.slima.teamworksample.core.models.QuickAddTask;
import com.slima.teamworksample.core.models.CallTasksList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by sergio.lima on 09/10/2017.
 */

public interface TeamWorkAPI {

    @GET("projects.json")
    Call<CallProjects> getAllProjects();

    @GET("tasks.json")
    Call<CallTasks> getAllTasks();

    @GET("projects/{id}/tasks.json")
    Call<CallTasks> getTasksPerProject(@Path("id") String projectId);


    @GET("account.json")
    Call<CallAccount> getAccountDetails();

    @GET("projects/{id}/tasklists.json")
    Call<CallTasksList> getTaskListsPerProject(@Path("id") String projectId);


    @POST("tasklists/{task_list_id}/quickadd.json")
    Call<PostResult> quickAddTask(@Path("task_list_id") Integer taskListId, @Body QuickAddTask taskToAdd);
}
