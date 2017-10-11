package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sergio.lima on 09/10/2017.
 */

public class QuickTodoItem {

    @SerializedName("responsible-party-id")
    @Expose
    public String responsiblePartyId;
    @SerializedName("start-date")
    @Expose
    public String startDate;
    @SerializedName("due-date")
    @Expose
    public String dueDate;
}
