
package com.slima.teamworksample.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

    @SerializedName("replyByEmailEnabled")
    @Expose
    public Boolean replyByEmailEnabled;
    @SerializedName("starred")
    @Expose
    public Boolean starred;
    @SerializedName("show-announcement")
    @Expose
    public Boolean showAnnouncement;
    @SerializedName("harvest-timers-enabled")
    @Expose
    public Boolean harvestTimersEnabled;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("subStatus")
    @Expose
    public String subStatus;
    @SerializedName("defaultPrivacy")
    @Expose
    public String defaultPrivacy;
    @SerializedName("integrations")
    @Expose
    public Integrations integrations;
    @SerializedName("created-on")
    @Expose
    public String createdOn;
    @SerializedName("category")
    @Expose
    public Category category;
    @SerializedName("filesAutoNewVersion")
    @Expose
    public Boolean filesAutoNewVersion;
    @SerializedName("overview-start-page")
    @Expose
    public String overviewStartPage;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("last-changed-on")
    @Expose
    public String lastChangedOn;
    @SerializedName("endDate")
    @Expose
    public String endDate;
    @SerializedName("defaults")
    @Expose
    public Defaults defaults;
    @SerializedName("company")
    @Expose
    public Company company;
    @SerializedName("tasks-start-page")
    @Expose
    public String tasksStartPage;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("privacyEnabled")
    @Expose
    public Boolean privacyEnabled;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("announcement")
    @Expose
    public String announcement;
    @SerializedName("isProjectAdmin")
    @Expose
    public Boolean isProjectAdmin;
    @SerializedName("start-page")
    @Expose
    public String startPage;
    @SerializedName("notifyeveryone")
    @Expose
    public Boolean notifyeveryone;
    @SerializedName("boardData")
    @Expose
    public BoardData boardData;
    @SerializedName("announcementHTML")
    @Expose
    public String announcementHTML;

}
