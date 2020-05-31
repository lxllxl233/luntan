package com.xinli.xinli.websocket.bean;

import java.io.Serializable;

//模型的坐标
public class Location implements Serializable {

    private Integer id;
    //模型 id
    private Integer mdId;
    private Integer x;
    private Integer y;
    //缩放度
    private Float zoom;

    public Location( ) {
    }

    public Location(Integer id, Integer mdId, Integer x, Integer y, Float zoom) {
        this.id = id;
        this.mdId = mdId;
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getMdId() {
        return mdId;
    }

    public void setMdId(Integer mdId) {
        this.mdId = mdId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Float getZoom() {
        return zoom;
    }

    public void setZoom(Float zoom) {
        this.zoom = zoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", mdId=" + mdId +
                ", x=" + x +
                ", y=" + y +
                ", zoom=" + zoom +
                '}';
    }
}
