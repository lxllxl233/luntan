package com.xinli.xinli.websocket.bean;

import java.io.Serializable;

public class Operating implements Serializable {
    //0增加,1修改,2删除
    private Integer type;
    private Location location;
    public Operating() {
    }

    public Operating(Integer type, Location location) {
        this.type = type;
        this.location = location;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
