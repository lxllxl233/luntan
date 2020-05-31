package com.xinli.xinli.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_advisory", schema = "xinli", catalog = "")
public class TbAdvisoryEntity {
    private Integer adId;
    private Integer userId;
    private Integer masterConsultantId;
    private Integer masterSupervisorId;
    private Integer appId;
    private Timestamp adTime;
    private String adUserEvaluation;
    private String adConsultantEvaluation;
    private String adConsultantRecording;
    private String adImgUrl1;
    private String adImgUrl2;

    @Id
    @Column(name = "ad_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "master_consultant_id", nullable = false)
    public Integer getMasterConsultantId() {
        return masterConsultantId;
    }

    public void setMasterConsultantId(Integer masterConsultantId) {
        this.masterConsultantId = masterConsultantId;
    }

    @Basic
    @Column(name = "master_supervisor_id", nullable = true)
    public Integer getMasterSupervisorId() {
        return masterSupervisorId;
    }

    public void setMasterSupervisorId(Integer masterSupervisorId) {
        this.masterSupervisorId = masterSupervisorId;
    }

    @Basic
    @Column(name = "ad_time", nullable = true)
    public Timestamp getAdTime() {
        return adTime;
    }

    public void setAdTime(Timestamp adTime) {
        this.adTime = adTime;
    }

    @Basic
    @Column(name = "ad_user_evaluation", nullable = true, length = 1024)
    public String getAdUserEvaluation() {
        return adUserEvaluation;
    }

    public void setAdUserEvaluation(String adUserEvaluation) {
        this.adUserEvaluation = adUserEvaluation;
    }

    @Basic
    @Column(name = "ad_consultant_evaluation", nullable = true, length = 1024)
    public String getAdConsultantEvaluation() {
        return adConsultantEvaluation;
    }

    public void setAdConsultantEvaluation(String adConsultantEvaluation) {
        this.adConsultantEvaluation = adConsultantEvaluation;
    }

    @Basic
    @Column(name = "ad_consultant_recording", nullable = true, length = 1024)
    public String getAdConsultantRecording() {
        return adConsultantRecording;
    }

    public void setAdConsultantRecording(String adConsultantRecording) {
        this.adConsultantRecording = adConsultantRecording;
    }

    @Basic
    @Column(name = "ad_img_url1", nullable = true, length = 255)
    public String getAdImgUrl1() {
        return adImgUrl1;
    }

    public void setAdImgUrl1(String adImgUrl1) {
        this.adImgUrl1 = adImgUrl1;
    }

    @Basic
    @Column(name = "ad_img_url2", nullable = true, length = 255)
    public String getAdImgUrl2() {
        return adImgUrl2;
    }

    public void setAdImgUrl2(String adImgUrl2) {
        this.adImgUrl2 = adImgUrl2;
    }

    @Basic
    @Column(name = "app_id", nullable = true)
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAdvisoryEntity that = (TbAdvisoryEntity) o;
        return adId == that.adId &&
                userId == that.userId &&
                masterConsultantId == that.masterConsultantId &&
                Objects.equals(masterSupervisorId, that.masterSupervisorId) &&
                Objects.equals(adTime, that.adTime) &&
                Objects.equals(adUserEvaluation, that.adUserEvaluation) &&
                Objects.equals(adConsultantEvaluation, that.adConsultantEvaluation) &&
                Objects.equals(adConsultantRecording, that.adConsultantRecording) &&
                Objects.equals(adImgUrl1, that.adImgUrl1) &&
                Objects.equals(adImgUrl2, that.adImgUrl2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, userId, masterConsultantId, masterSupervisorId, adTime, adUserEvaluation, adConsultantEvaluation, adConsultantRecording, adImgUrl1, adImgUrl2);
    }
}
