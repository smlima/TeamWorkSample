
package com.slima.teamworksample.core.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tasklist {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("milestone-id")
    @Expose
    public String milestoneId;
    @SerializedName("uncompleted-count")
    @Expose
    public String uncompletedCount;
    @SerializedName("projectName")
    @Expose
    public String projectName;
    @SerializedName("complete")
    @Expose
    public Boolean complete;
    @SerializedName("projectId")
    @Expose
    public String projectId;
    @SerializedName("private")
    @Expose
    public Boolean _private;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("isTemplate")
    @Expose
    public Boolean isTemplate;
    @SerializedName("tags")
    @Expose
    public List<Object> tags = null;
    @SerializedName("pinned")
    @Expose
    public Boolean pinned;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("position")
    @Expose
    public String position;

}
