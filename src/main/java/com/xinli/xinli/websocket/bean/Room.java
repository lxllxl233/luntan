package com.xinli.xinli.websocket.bean;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    //房间id
    private String roomId;
    private Integer appId;
    private Members members;
    //模型坐标
    private List<Location> locations;

    public Room() {
    }

    public Room(String roomId, Members members, List<Location> locations,Integer appId) {
        this.roomId = roomId;
        this.members = members;
        this.locations = locations;
        this.appId = appId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    //添加/修改模型位置
    public Operating addAndUpdateModel(Location location){
        Operating operating = null;
        if (locations.size() == 0){
            locations.add(location);
            operating = new Operating(0,location);
        }else {
            boolean b = false;
            int i = 0;
            for (Location location1 : locations) {
                if (location1.getId().equals(location.getId())){
                    b = true;
                    break;
                }
                i++;
            }

            if (b){
                //更新位置
                locations.set(i,location);
                operating = new Operating(1, location);
            }else {
                locations.add(location);
                operating = new Operating(0, location);
            }
        }
        return operating;
    }

    //删除模型
    public Operating deleteModel(Location location){
        boolean b = locations.removeIf(e -> e.getMdId().equals(location.getMdId()));
        Operating operating = new Operating(2, location);
        return operating;
    }

}















