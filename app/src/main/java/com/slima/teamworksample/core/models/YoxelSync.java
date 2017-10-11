
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YoxelSync {

    @SerializedName("enabled")
    @Expose
    public Boolean enabled;
    @SerializedName("available")
    @Expose
    public Boolean available;

}
