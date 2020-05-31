package com.xinli.xinli.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_user", schema = "xinli", catalog = "")
public class TbUserEntity {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userAge;
    private String userHeadImg;
    private String userPhone;
    private String userFrequency;
    private Timestamp userDeadline;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 64)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 64)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_age", nullable = true, length = 64)
    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_head_img", nullable = true, length = 255)
    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }

    @Basic
    @Column(name = "user_phone", nullable = true, length = 64)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_frequency", nullable = true, length = 64)
    public String getUserFrequency() {
        return userFrequency;
    }

    public void setUserFrequency(String userFrequency) {
        this.userFrequency = userFrequency;
    }

    @Basic
    @Column(name = "user_deadline", nullable = true)
    public Timestamp getUserDeadline() {
        return userDeadline;
    }

    public void setUserDeadline(Timestamp userDeadline) {
        this.userDeadline = userDeadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUserEntity that = (TbUserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userAge, that.userAge) &&
                Objects.equals(userHeadImg, that.userHeadImg) &&
                Objects.equals(userPhone, that.userPhone) &&
                Objects.equals(userFrequency, that.userFrequency) &&
                Objects.equals(userDeadline, that.userDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPassword, userAge, userHeadImg, userPhone, userFrequency, userDeadline);
    }
}
