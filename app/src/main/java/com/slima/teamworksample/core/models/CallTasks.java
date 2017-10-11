
package com.slima.teamworksample.core.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallTasks {

    @SerializedName("STATUS")
    @Expose
    public String sTATUS;
    @SerializedName("todo-items")
    @Expose
    public List<TodoItem> todoItems = null;

}
