
package com.slima.teamworksample.core.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallProjects {

    @SerializedName("STATUS")
    @Expose
    public String sTATUS;

    @SerializedName("projects")
    @Expose
    public List<Project> projects = null;

}
