
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Integrations {

    @SerializedName("microsoftConnectors")
    @Expose
    public MicrosoftConnectors microsoftConnectors;
    @SerializedName("onedrivebusiness")
    @Expose
    public Onedrivebusiness onedrivebusiness;

}
