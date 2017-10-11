package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sergio.lima on 09/10/2017.
 */

public class QuickAddTask {

    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("tasklistId")
    @Expose
    public Integer tasklistId;
    @SerializedName("creator-id")
    @Expose
    public Integer creatorId;
    @SerializedName("notify")
    @Expose
    public Boolean notify;
    @SerializedName("private")
    @Expose
    public Boolean _private;

    @SerializedName("todo-item")
    @Expose
    public TodoItem todoItem;
}
