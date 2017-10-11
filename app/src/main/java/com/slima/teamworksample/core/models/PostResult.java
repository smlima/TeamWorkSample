
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResult {

    @SerializedName("tasklistId")
    @Expose
    public String tasklistId;
    @SerializedName("success")
    @Expose
    public String success;
    @SerializedName("taskIds")
    @Expose
    public String taskIds;
    @SerializedName("STATUS")
    @Expose
    public String sTATUS;
    @SerializedName("failed")
    @Expose
    public String failed;

}
