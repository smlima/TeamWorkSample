package com.slima.teamworksample.core.services;

import android.content.Context;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.models.Account;
import com.slima.teamworksample.core.models.CallAccount;
import com.slima.teamworksample.core.models.CallProjects;
import com.slima.teamworksample.core.models.CallTasks;
import com.slima.teamworksample.core.models.CallTasksList;
import com.slima.teamworksample.core.models.PostResult;
import com.slima.teamworksample.core.models.Project;
import com.slima.teamworksample.core.models.QuickAddTask;
import com.slima.teamworksample.core.models.Tasklist;
import com.slima.teamworksample.core.models.TodoItem;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.repositories.TeamWorkAPI;
import com.slima.teamworksample.dagger.AppContext;

import java.io.IOException;
import java.util.List;

import dagger.Reusable;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sergio.lima on 07/10/2017.
 */
@Reusable
public class NetworkService {

    final Context mContext;

    final private ResourcesService mResourcesService;
    private TeamWorkAPI mTeamWorkAPI;

    public NetworkService(@AppContext Context context, ResourcesService resourcesService) {
        mContext = context;
        mResourcesService = resourcesService;
        setup();
    }

    private void setup() {

        String baseUrl = mResourcesService.getString(R.string.base_url);
        String apiKey = mResourcesService.getString(R.string.api_key);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new AuthenticationInterceptor(Credentials.basic(apiKey, "xxx")))
                ;


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        mTeamWorkAPI = retrofit.create(TeamWorkAPI.class);
    }

    public void getAccountDetails(final RepositoryCallback<Account> callAccountRepositoryCallback) {
        Call<CallAccount> accountDetails = mTeamWorkAPI.getAccountDetails();

        accountDetails.enqueue(new Callback<CallAccount>() {
            @Override
            public void onResponse(Call<CallAccount> call, retrofit2.Response<CallAccount> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callAccountRepositoryCallback.onSuccess(response.body().account);
                } else {
                    callAccountRepositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<CallAccount> call, Throwable t) {
                callAccountRepositoryCallback.onError(t);
            }
        });

    }

    public void getAllProjects(final RepositoryCallback<List<Project>> repositoryCallback) {
        mTeamWorkAPI.getAllProjects().enqueue(new Callback<CallProjects>() {
            @Override
            public void onResponse(Call<CallProjects> call, retrofit2.Response<CallProjects> response) {
                if (response.isSuccessful() && response.body() != null) {
                    repositoryCallback.onSuccess(response.body().projects);
                } else {
                    repositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<CallProjects> call, Throwable t) {
                repositoryCallback.onError(t);
            }
        });

    }

    public void getTasksPerProject(String projectId, final RepositoryCallback<List<TodoItem>> repositoryCallback) {
        mTeamWorkAPI.getTasksPerProject(projectId).enqueue(new Callback<CallTasks>() {
            @Override
            public void onResponse(Call<CallTasks> call, retrofit2.Response<CallTasks> response) {
                if (response.isSuccessful() && response.body() != null) {
                    repositoryCallback.onSuccess(response.body().todoItems);
                } else {
                    repositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<CallTasks> call, Throwable t) {
                repositoryCallback.onError(t);
            }
        });
    }

    public void getTaskListPerProject(String projectId, final RepositoryCallback<List<Tasklist>> repositoryCallback) {
        mTeamWorkAPI.getTaskListsPerProject(projectId).enqueue(new Callback<CallTasksList>() {
            @Override
            public void onResponse(Call<CallTasksList> call, retrofit2.Response<CallTasksList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    repositoryCallback.onSuccess(response.body().tasklists);
                } else {
                    repositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<CallTasksList> call, Throwable t) {
                repositoryCallback.onError(t);
            }
        });
    }


    public void getAllMyTasksBlocking(final RepositoryCallback<List<TodoItem>> repositoryCallback) {

        mTeamWorkAPI.getAllTasks().enqueue(new Callback<CallTasks>(){
            @Override
            public void onResponse(Call<CallTasks> call, retrofit2.Response<CallTasks> response) {
                if (response.isSuccessful() && response.body() != null) {
                    repositoryCallback.onSuccess(response.body().todoItems);
                } else {
                    repositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<CallTasks> call, Throwable t) {
                repositoryCallback.onError(t);
            }
        });
    }

    public void addQuickTask(QuickAddTask quickAddTask, final RepositoryCallback<PostResult> repositoryCallback) {
        Call<PostResult> postResultCall = mTeamWorkAPI.quickAddTask(quickAddTask.tasklistId, quickAddTask);
        postResultCall.enqueue(new Callback<PostResult>() {
            @Override
            public void onResponse(Call<PostResult> call, retrofit2.Response<PostResult> response) {
                if (response.isSuccessful() && response.body() != null) {
                    repositoryCallback.onSuccess(response.body());
                } else {
                    repositoryCallback.onError(new IllegalStateException("Some problem with the response"));
                }
            }

            @Override
            public void onFailure(Call<PostResult> call, Throwable t) {
                repositoryCallback.onError(t);
            }
        });
    }

}

/**
 * Add api_key on all requests
 */
class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    public AuthenticationInterceptor(String token) {
        this.authToken = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", authToken);

        Request request = builder.build();
        return chain.proceed(request);
    }
}
