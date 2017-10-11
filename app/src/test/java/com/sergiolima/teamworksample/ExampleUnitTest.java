package com.sergiolima.teamworksample;

import android.content.Context;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.models.Account;
import com.slima.teamworksample.core.models.Project;
import com.slima.teamworksample.core.models.TodoItem;
import com.slima.teamworksample.core.repositories.RepositoryCallback;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.services.ResourcesService;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test_check_teamwork_api_rest_calls() throws Exception {
        assertEquals(4, 2 + 2);

        Context context = Mockito.mock(Context.class);
        ResourcesService resourcesService = Mockito.mock(ResourcesService.class);

        Mockito.when(resourcesService.getString(Mockito.eq(R.string.base_url))).thenReturn("https://yat.teamwork.com/");
        Mockito.when(resourcesService.getString(Mockito.eq(R.string.api_key))).thenReturn("twp_TEbBXGCnvl2HfvXWfkLUlzx92e3T");

        NetworkService networkService = new NetworkService(context, resourcesService);

        networkService.getAccountDetails(new RepositoryCallback<Account>() {
            @Override
            public void onSuccess(Account value) {
                assertEquals("349705", value.id);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

        networkService.getAllProjects(new RepositoryCallback<List<Project>>() {
            @Override
            public void onSuccess(List<Project> value) {
                assertEquals(2, value.size());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });



        networkService.getTasksPerProject("1", new RepositoryCallback<List<TodoItem>>() {
            @Override
            public void onSuccess(List<TodoItem> value) {
                assertTrue(value.size() >= 31);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


    }
}