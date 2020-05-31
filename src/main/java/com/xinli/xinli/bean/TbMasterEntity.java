package com.xinli.xinli.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_master", schema = "xinli", catalog = "")
public class TbMasterEntity {
    private Integer masterId;
    private String masterName;
    private String masterPassword;
    private String masterAge;
    private String masterHeadImg;
    private String masterPhone;
    private String masterQualification;
    private String masterExperience;
    private Integer masterAuthority;
    private Timestamp masterDeadline;

    @Id
    @Column(name = "master_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    @Basic
    @Column(name = "master_name", nullable = true, length = 64)
    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Basic
    @Column(name = "master_password", nullable = true, length = 64)
    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    @Basic
    @Column(name = "master_age", nullable = true, length = 64)
    public String getMasterAge() {
        return masterAge;
    }

    public void setMasterAge(String masterAge) {
        this.masterAge = masterAge;
    }

    @Basic
    @Column(name = "master_head_img", nullable = true, length = 255)
    public String getMasterHeadImg() {
        return masterHeadImg;
    }

    public void setMasterHeadImg(String masterHeadImg) {
        this.masterHeadImg = masterHeadImg;
    }

    @Basic
    @Column(name = "master_phone", nullable = true, length = 64)
    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    @Basic
    @Column(name = "master_qualification", nullable = true, length = 1024)
    public String getMasterQualification() {
        return masterQualification;
    }

    public void setMasterQualification(String masterQualification) {
        this.masterQualification = masterQualification;
    }

    @Basic
    @Column(name = "master_experience", nullable = true, length = 1024)
    public String getMasterExperience() {
        return masterExperience;
    }

    public void setMasterExperience(String masterExperience) {
        this.masterExperience = masterExperience;
    }

    @Basic
    @Column(name = "master_authority", nullable = false)
    public Integer getMasterAuthority() {
        return masterAuthority;
    }

    public void setMasterAuthority(Integer masterAuthority) {
        this.masterAuthority = masterAuthority;
    }

    @Basic
    @Column(name = "master_deadline", nullable = true)
    public Timestamp getMasterDeadline() {
        return masterDeadline;
    }

    public void setMasterDeadline(Timestamp masterDeadline) {
        this.masterDeadline = masterDeadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbMasterEntity that = (TbMasterEntity) o;
        return masterId == that.masterId &&
                masterAuthority == that.masterAuthority &&
                Objects.equals(masterName, that.masterName) &&
                Objects.equals(masterPassword, that.masterPassword) &&
                Objects.equals(masterAge, that.masterAge) &&
                Objects.equals(masterHeadImg, that.masterHeadImg) &&
                Objects.equals(masterPhone, that.masterPhone) &&
                Objects.equals(masterQualification, that.masterQualification) &&
                Objects.equals(masterExperience, that.masterExperience) &&
                Objects.equals(masterDeadline, that.masterDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterId, masterName, masterPassword, masterAge, masterHeadImg, masterPhone, masterQualification, masterExperience, masterAuthority, masterDeadline);
    }
}
