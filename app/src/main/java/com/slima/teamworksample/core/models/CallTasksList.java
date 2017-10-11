
package com.slima.teamworksample.core.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallTasksList {

    @SerializedName("tasklists")
    @Expose
    public List<Tasklist> tasklists = null;
    @SerializedName("STATUS")
    @Expose
    public String sTATUS;

}
