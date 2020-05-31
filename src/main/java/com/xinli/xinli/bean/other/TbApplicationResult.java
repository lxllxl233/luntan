package com.xinli.xinli.bean.other;

import com.xinli.xinli.bean.TbMasterEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_advisory", schema = "xinli", catalog = "")
public class TbApplicationResult {
    private Integer adId;
    private Integer userId;
    private Integer masterConsultantId;
    private Integer masterSupervisorId;
    private Timestamp adTime;
    private String adUserEvaluation;
    private String adConsultantEvaluation;
    private String adConsultantRecording;
    private String adImgUrl1;
    private String adImgUrl2;

    private TbMasterEntity masterConsultant;
    private TbMasterEntity masterSupervisor;

    @OneToOne
    @JoinColumn(name = "master_consultant_id",insertable = false,updatable = false)
    public TbMasterEntity getMasterConsultant() {
        return masterConsultant;
    }

    public void setMasterConsultant(TbMasterEntity masterConsultant) {
        this.masterConsultant = masterConsultant;
    }

    @OneToOne
    @JoinColumn(name = "master_supervisor_id",insertable = false,updatable = false)
    public TbMasterEntity getMasterSupervisor() {
        return masterSupervisor;
    }

    public void setMasterSupervisor(TbMasterEntity masterSupervisor) {
        this.masterSupervisor = masterSupervisor;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.xinli.xinli.bean.TbAdvisoryEntity that = (com.xinli.xinli.bean.TbAdvisoryEntity) o;
        return adId == that.getAdId() &&
                userId == that.getUserId() &&
                masterConsultantId == that.getMasterConsultantId() &&
                Objects.equals(masterSupervisorId, that.getMasterSupervisorId()) &&
                Objects.equals(adTime, that.getAdTime()) &&
                Objects.equals(adUserEvaluation, that.getAdUserEvaluation()) &&
                Objects.equals(adConsultantEvaluation, that.getAdConsultantEvaluation()) &&
                Objects.equals(adConsultantRecording, that.getAdConsultantRecording()) &&
                Objects.equals(adImgUrl1, that.getAdImgUrl1()) &&
                Objects.equals(adImgUrl2, that.getAdImgUrl2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, userId, masterConsultantId, masterSupervisorId, adTime, adUserEvaluation, adConsultantEvaluation, adConsultantRecording, adImgUrl1, adImgUrl2);
    }
}
