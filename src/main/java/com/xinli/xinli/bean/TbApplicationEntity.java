package com.xinli.xinli.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_application", schema = "xinli", catalog = "")
public class TbApplicationEntity {
    private int appId;
    private int userId;
    private int masterConsultantId;
    private Timestamp appTime;
    private Timestamp appOptime;
    private Timestamp appBeginTime;
    private int appDuration;
    private String appDescription;
    private int appStatus;

    @Id
    @Column(name = "app_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "master_consultant_id", nullable = false)
    public int getMasterConsultantId() {
        return masterConsultantId;
    }

    public void setMasterConsultantId(int masterConsultantId) {
        this.masterConsultantId = masterConsultantId;
    }

    @Basic
    @Column(name = "app_time", nullable = true)
    public Timestamp getAppTime() {
        return appTime;
    }

    public void setAppTime(Timestamp appTime) {
        this.appTime = appTime;
    }

    @Basic
    @Column(name = "app_optime", nullable = true)
    public Timestamp getAppOptime() {
        return appOptime;
    }

    public void setAppOptime(Timestamp appOptime) {
        this.appOptime = appOptime;
    }

    @Basic
    @Column(name = "app_begin_time", nullable = true)
    public Timestamp getAppBeginTime() {
        return appBeginTime;
    }

    public void setAppBeginTime(Timestamp appBeginTime) {
        this.appBeginTime = appBeginTime;
    }

    @Basic
    @Column(name = "app_duration", nullable = false)
    public int getAppDuration() {
        return appDuration;
    }

    public void setAppDuration(int appDuration) {
        this.appDuration = appDuration;
    }

    @Basic
    @Column(name = "app_description", nullable = true, length = 1024)
    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    @Basic
    @Column(name = "app_status", nullable = false)
    public int getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbApplicationEntity that = (TbApplicationEntity) o;
        return appId == that.appId &&
                userId == that.userId &&
                masterConsultantId == that.masterConsultantId &&
                appDuration == that.appDuration &&
                appStatus == that.appStatus &&
                Objects.equals(appTime, that.appTime) &&
                Objects.equals(appOptime, that.appOptime) &&
                Objects.equals(appBeginTime, that.appBeginTime) &&
                Objects.equals(appDescription, that.appDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, userId, masterConsultantId, appTime, appOptime, appBeginTime, appDuration, appDescription, appStatus);
    }
}
