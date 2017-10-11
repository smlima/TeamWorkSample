package com.slima.teamworksample.modules.viewmodels;

import android.databinding.Bindable;

import com.slima.teamworksample.core.models.Project;
import com.slima.teamworksample.core.viewmodels.ItemViewModel;


/**
 * Created by sergio.lima on 10/10/2017.
 */

public class ProjectViewModel extends ItemViewModel<Project> {

    public ProjectViewModel() {
    }

    public ProjectViewModel(Project item) {
        super(item);
    }

    public String getDescription(){
        return getItem().description;
    }

    public String getName(){
        return getItem().name;
    }

    public String getStartDate(){
        return getItem().startDate;
    }

    public String getEndDate() {
        return getItem().endDate;
    }

    @Bindable
    public String getLogoUrl(){
        return getItem().logo;
    }



}
