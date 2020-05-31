package com.xinli.xinli.websocket.bean.request;

import com.xinli.xinli.websocket.bean.Location;
import com.xinli.xinli.websocket.bean.Members;

import java.io.Serializable;

public class WebsocketRequestMsg implements Serializable {
    //0创建房间 1获取房间id 2添加/修改模型位置 3删除模型 4移除房间
    private Integer type;
    private Integer userId;
    private Integer appId;
    private String roomId;
    private Location location;
    private Members members;

    public WebsocketRequestMsg() {
    }

    public WebsocketRequestMsg(Integer type, Integer userId, String roomId, Location location, Members members,Integer appId) {
        this.type = type;
        this.userId = userId;
        this.roomId = roomId;
        this.location = location;
        this.members = members;
        this.appId = appId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

}
