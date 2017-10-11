package com.slima.teamworksample.core.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import com.slima.teamworksample.R;
import com.slima.teamworksample.core.components.ui.SinglePageComponent;
import com.slima.teamworksample.databinding.ActivityFragmentHostBinding;
import com.slima.teamworksample.modules.components.AccountDetailsComponent;
import com.slima.teamworksample.modules.components.ProjectListComponent;
import com.slima.teamworksample.modules.components.ProjectTasksListComponent;


/**
 * Created by sergio.lima on 07/10/2017.
 */
public class FragmentHostActivity extends BaseActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_account:
                    AccountDetailsComponent accountDetailsComponent = new AccountDetailsComponent();
                    mNavigationService.openInnerComponent(accountDetailsComponent);
                    return true;
                case R.id.navigation_projects:
                    ProjectListComponent projectListComponent = new ProjectListComponent();
                    mNavigationService.openInnerComponent(projectListComponent);
                    return true;
                case R.id.navigation_taskslist:
                    ProjectTasksListComponent projectTasksListComponent = new ProjectTasksListComponent();
                    mNavigationService.openInnerComponent(projectTasksListComponent);
                    return true;

            }
            return false;
        }
    };
    private BottomNavigationView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFragmentHostBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_host);
        binding.setVm(getViewModel());
        final View root = binding.getRoot();

        initialSettingsDoneHereForSimplicity();
        setupActivity(savedInstanceState, root);

        replaceFragment(getTopComponentFragment(getViewModel().getPageComponent()));

        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mNavigation.setSelectedItemId(R.id.navigation_projects);
    }

    @Override
    int getFragmentContainerId() {
        return R.id.layout_fragment_host_main;
    }

    /**
     * FIXME: ...
     *
     * For the sake of simplicity the initialization of the page and respective
     * component was made here on this activity. But it should be done outside
     * because this activity (VIEW on MVVM) has/should not have any insight on the data(MODEL)
     * to be rendered.
     *
     */
    void initialSettingsDoneHereForSimplicity(){


        ProjectListComponent projectListComponent = new ProjectListComponent();
        SinglePageComponent pageComponent = new SinglePageComponent(projectListComponent);
        getViewModel().setPageComponent(pageComponent);

    }

}
