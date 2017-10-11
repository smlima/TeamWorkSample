package com.slima.teamworksample.application.ioc;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.core.services.NavigationService;
import com.slima.teamworksample.core.services.NetworkService;
import com.slima.teamworksample.core.services.ResourcesService;
import com.slima.teamworksample.core.services.ViewModelFactory;
import com.slima.teamworksample.core.viewmodels.pages.PageViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * Created by sergio.lima on 07/10/2017.
 */
@Module
public class AppModule {

    private TeamWorkSampleApplication mAppContext;

    public AppModule(TeamWorkSampleApplication appContext){
        mAppContext = appContext;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mAppContext);
    }

    @Provides
    PageViewModel providesPageViewModel(){
        return new PageViewModel();
    }

    @Provides
    @Singleton
    NavigationService providesNavigationService(){
        return new NavigationService(mAppContext);
    }

    @Provides
    @Reusable
    NetworkService providesNetworkService(ResourcesService resourcesService){
        return new NetworkService(mAppContext, resourcesService);
    }

    @Provides
    ResourcesService providesResourcesService(){
        return new ResourcesService(mAppContext);
    }

    @Provides
    @Singleton
    ViewModelFactory providesViewModelFactory(ResourcesService resourcesService, NavigationService navigationService, NetworkService networkService){
        return new ViewModelFactory(resourcesService, navigationService, networkService);
    }
}
