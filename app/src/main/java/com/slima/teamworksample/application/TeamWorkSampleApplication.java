package com.slima.teamworksample.application;

import android.app.Application;

import com.slima.teamworksample.application.ioc.AppModule;
import com.slima.teamworksample.application.ioc.DaggerTWComponent;
import com.slima.teamworksample.application.ioc.TWComponent;

/**
 * Created by sergio.lima on 07/10/2017.
 */

public class TeamWorkSampleApplication extends Application {


    private static TeamWorkSampleApplication sInstance;
    private TWComponent mRootComponent;

    public static TeamWorkSampleApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        mRootComponent = DaggerTWComponent.builder()
                .appModule(new AppModule(sInstance))
                .build();

    }

    public TWComponent getRootComponent() {
        return mRootComponent;
    }
}
