package com.slima.teamworksample.application.ioc;

import com.slima.teamworksample.application.TeamWorkSampleApplication;
import com.slima.teamworksample.core.components.ui.UIBaseComponent;
import com.slima.teamworksample.core.viewmodels.components.BaseComponentViewModel;
import com.slima.teamworksample.core.views.activities.BaseActivity;
import com.slima.teamworksample.core.views.fragments.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sergio.lima on 07/10/2017.
 */

@Singleton
@Component (modules = AppModule.class)
public interface TWComponent {
    void inject(TeamWorkSampleApplication application);
    void inject(BaseActivity baseActivity);

    void inject(BaseFragment baseFragment);

}
