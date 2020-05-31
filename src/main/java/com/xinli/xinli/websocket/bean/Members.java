package com.xinli.xinli.websocket.bean;

import java.io.Serializable;

public class Members implements Serializable {
    private Integer userId;
    private Integer consultantId;
    private Integer supervisorId;

    public Members() {
    }

    public Members(Integer userId, Integer consultantId, Integer supervisorId) {
        this.userId = userId;
        this.consultantId = consultantId;
        this.supervisorId = supervisorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }
}
