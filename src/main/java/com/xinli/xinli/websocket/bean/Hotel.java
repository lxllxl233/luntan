package com.xinli.xinli.websocket.bean;

import java.io.Serializable;
import java.util.*;

public class Hotel implements Serializable {

    private Map<Integer,String> roomIds = null;
    private Map<String,Room> roomMap = null;

    public Hotel() {
        roomMap = new HashMap<>();
        roomIds = new HashMap<>();
    }

    public Hotel(Map<Integer, String> roomIds, Map<String, Room> roomMap) {
        this.roomIds = roomIds;
        this.roomMap = roomMap;
    }


    public Map<Integer, String> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(Map<Integer, String> roomIds) {
        this.roomIds = roomIds;
    }

    public Map<String, Room> getRoomMap() {
        return roomMap;
    }



    public String addRoom(Integer userId,String roomId, Room room){
        if (!roomIds.containsKey(userId)) {
            roomIds.put(userId, roomId);
            roomMap.put(roomId, room);
            return roomId;
        }else {
            return roomIds.get(userId);
        }
    }

    public Room getRoom(String roomId){
        return roomMap.get(roomId);
    }

    public Room getRoom(Integer userId, Integer cid){
        String aLong = roomIds.get(cid);
        if (roomMap.containsKey(aLong)){
            Room room = roomMap.get(aLong);
            if (room.getMembers().getUserId().equals(userId)){
                return room;
            }
        }
        return null;
    }

    public void removeRoom(String roomId,Integer userId){
        System.out.println("移除了房间 -- "+userId+":"+roomId);
        roomIds.remove(userId);
        roomMap.remove(roomId);
    }

    public String getRoomId(Integer userId){
        return roomIds.get(userId);
    }

    public void updateRoom(String roomId,Room room){
        roomMap.put(roomId,room);
    }

    public List<Room> findRoom(Integer supervisorId){
        ArrayList<Room> list = new ArrayList<>();
        Set<String> longs = roomMap.keySet();
        for (String aLong : longs) {
            Room room = roomMap.get(aLong);
            if (room.getMembers().getSupervisorId().equals(supervisorId)){
                list.add(room);
            }
        }
        return list;
    }
}
