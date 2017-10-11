
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HubSpot {

    @SerializedName("enabled")
    @Expose
    public Boolean enabled;
    @SerializedName("portalId")
    @Expose
    public String portalId;

}
