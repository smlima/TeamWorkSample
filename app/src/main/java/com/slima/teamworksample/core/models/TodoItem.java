
package com.slima.teamworksample.core.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodoItem {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("canComplete")
    @Expose
    public Boolean canComplete;
    @SerializedName("comments-count")
    @Expose
    public Integer commentsCount;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("has-reminders")
    @Expose
    public Boolean hasReminders;
    @SerializedName("has-unread-comments")
    @Expose
    public Boolean hasUnreadComments;
    @SerializedName("private")
    @Expose
    public Integer _private;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("order")
    @Expose
    public Integer order;
    @SerializedName("project-id")
    @Expose
    public Integer projectId;
    @SerializedName("project-name")
    @Expose
    public String projectName;
    @SerializedName("todo-list-id")
    @Expose
    public Integer todoListId;
    @SerializedName("todo-list-name")
    @Expose
    public String todoListName;
    @SerializedName("tasklist-private")
    @Expose
    public Boolean tasklistPrivate;
    @SerializedName("tasklist-isTemplate")
    @Expose
    public Boolean tasklistIsTemplate;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("company-name")
    @Expose
    public String companyName;
    @SerializedName("company-id")
    @Expose
    public Integer companyId;
    @SerializedName("creator-id")
    @Expose
    public Integer creatorId;
    @SerializedName("creator-firstname")
    @Expose
    public String creatorFirstname;
    @SerializedName("creator-lastname")
    @Expose
    public String creatorLastname;
    @SerializedName("completed")
    @Expose
    public Boolean completed;
    @SerializedName("start-date")
    @Expose
    public String startDate;
    @SerializedName("due-date-base")
    @Expose
    public String dueDateBase;
    @SerializedName("due-date")
    @Expose
    public String dueDate;
    @SerializedName("created-on")
    @Expose
    public String createdOn;
    @SerializedName("last-changed-on")
    @Expose
    public String lastChangedOn;
    @SerializedName("position")
    @Expose
    public Integer position;
    @SerializedName("estimated-minutes")
    @Expose
    public Integer estimatedMinutes;
    @SerializedName("priority")
    @Expose
    public String priority;
    @SerializedName("progress")
    @Expose
    public Integer progress;
    @SerializedName("harvest-enabled")
    @Expose
    public Boolean harvestEnabled;
    @SerializedName("parentTaskId")
    @Expose
    public String parentTaskId;
    @SerializedName("lockdownId")
    @Expose
    public String lockdownId;
    @SerializedName("tasklist-lockdownId")
    @Expose
    public String tasklistLockdownId;
    @SerializedName("has-dependencies")
    @Expose
    public Integer hasDependencies;
    @SerializedName("has-predecessors")
    @Expose
    public Integer hasPredecessors;
    @SerializedName("hasTickets")
    @Expose
    public Boolean hasTickets;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    @SerializedName("timeIsLogged")
    @Expose
    public String timeIsLogged;
    @SerializedName("attachments-count")
    @Expose
    public Integer attachmentsCount;
    @SerializedName("predecessors")
    @Expose
    public List<Object> predecessors = null;
    @SerializedName("canEdit")
    @Expose
    public Boolean canEdit;
    @SerializedName("viewEstimatedTime")
    @Expose
    public Boolean viewEstimatedTime;
    @SerializedName("creator-avatar-url")
    @Expose
    public String creatorAvatarUrl;
    @SerializedName("canLogTime")
    @Expose
    public Boolean canLogTime;
    @SerializedName("userFollowingComments")
    @Expose
    public Boolean userFollowingComments;
    @SerializedName("userFollowingChanges")
    @Expose
    public Boolean userFollowingChanges;
    @SerializedName("DLM")
    @Expose
    public Integer dLM;

}
