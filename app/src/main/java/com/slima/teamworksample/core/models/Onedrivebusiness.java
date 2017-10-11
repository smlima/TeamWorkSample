
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Onedrivebusiness {

    @SerializedName("enabled")
    @Expose
    public Boolean enabled;
    @SerializedName("folder")
    @Expose
    public String folder;
    @SerializedName("account")
    @Expose
    public String account;
    @SerializedName("foldername")
    @Expose
    public String foldername;

}
