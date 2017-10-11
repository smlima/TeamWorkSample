
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("is-owner")
    @Expose
    public String isOwner;
    @SerializedName("id")
    @Expose
    public String id;

}
