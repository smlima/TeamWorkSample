
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallAccount {

    @SerializedName("STATUS")
    @Expose
    public String sTATUS;
    @SerializedName("account")
    @Expose
    public Account account;

}
