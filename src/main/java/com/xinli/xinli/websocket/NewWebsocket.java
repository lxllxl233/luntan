package com.xinli.xinli.websocket;

import com.alibaba.fastjson.JSON;
import com.xinli.xinli.bean.TbAdvisoryEntity;
import com.xinli.xinli.dao.TbAdvisoryDao;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.util.SnowflakeIdUtils;
import com.xinli.xinli.websocket.bean.*;
import com.xinli.xinli.websocket.bean.request.WebsocketRequestMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Component
//0用户 1咨询师,督导师
@ServerEndpoint(value = "/ws/getLocation/{mark}/{userId}")
public class NewWebsocket {
    private static TbAdvisoryDao tbAdvisoryDao;
    //定义组件
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    //此处是解决无法注入的关键
    private static ApplicationContext applicationContext;
    private static Map<Integer,Session> masterMap;
    private static Map<Integer,Session> userMap;
    public static void setApplicationContext(ApplicationContext applicationContext) {
        NewWebsocket.applicationContext = applicationContext;
        System.out.println("----------------");
        System.out.println(applicationContext);
        System.out.println("----------------");
    }

    public static SnowflakeIdUtils idWorker = null;
    public static Hotel hotel;
    @PostConstruct
    public void init() {
        System.out.println("websocket 加载");
        idWorker = new SnowflakeIdUtils(3, 1);
        hotel = new Hotel();
        masterMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("mark")Integer mark,@PathParam("userId")Integer userId) {
        tbAdvisoryDao = applicationContext.getBean(TbAdvisoryDao.class);
        int cnt = OnlineCount.incrementAndGet(); // 在线数加1
        System.out.println(mark);
        System.out.println(userId);
        if (mark.equals(0)){
            //用户 session
            userMap.put(userId,session);
        }
        if (mark.equals(1)){
            //咨询师/督导师 session
            masterMap.put(userId,session);
        }
        System.out.println("有客户端连接");
        try {
            SendMessage(session,"{\"code\":200,\"msg\":\"connect success\"}");
        } catch (Exception e) {
            System.out.println("IO异常-->{}"+ e);
        }

        System.out.println("当前在线人数 :" + cnt);
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        //在线数减一
        int cnt = OnlineCount.decrementAndGet();
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String requestParam, Session session,@PathParam("mark")Integer mark) {
        WebsocketRequestMsg websocketRequestMsg = JSON.parseObject(requestParam, WebsocketRequestMsg.class);
        if (websocketRequestMsg.getType().equals(0)){
            //创建房间
            long id = idWorker.nextId();
            String roomId = ""+id;
            String aLong = hotel.addRoom(websocketRequestMsg.getUserId(), roomId, new Room(roomId, websocketRequestMsg.getMembers(), new ArrayList<>(),websocketRequestMsg.getAppId()));
            CommonResponse<String> response = new CommonResponse<>(200, "创建成功", aLong);
            SendMessage(session,JSON.toJSONString(response));


        }else if (websocketRequestMsg.getType().equals(1)){
            //获取房间id
            Room room = hotel.getRoom(websocketRequestMsg.getUserId(),websocketRequestMsg.getMembers().getConsultantId());
            try {
                CommonResponse<String> response = new CommonResponse<>(200, "获取成功", room.getRoomId());
                SendMessage(session,JSON.toJSONString(response));
            }catch (Exception e){
                CommonResponse<String> response = new CommonResponse<>(800, "没有找到房间,刷新一下?", null);
                SendMessage(session,JSON.toJSONString(response));
            }


        }else if (websocketRequestMsg.getType().equals(2)){
            //添加/修改模型
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            Operating operating = room.addAndUpdateModel(websocketRequestMsg.getLocation());
            hotel.updateRoom(websocketRequestMsg.getRoomId(),room);
            Integer consultantId = room.getMembers().getConsultantId();
            Integer supervisorId = room.getMembers().getSupervisorId();
            Integer userId = room.getMembers().getUserId();
            if (mark.equals(0)) {
                //100
                //如果是用户摆放模型,通知督导师和咨询师
                if (masterMap.containsKey(consultantId)) {
                    SendMessage(masterMap.get(consultantId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
                if (masterMap.containsKey(supervisorId)) {
                    SendMessage(masterMap.get(supervisorId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }

            }
            if (mark.equals(1)) {
                //如果是督导师摆放模型,通知用户和咨询师
                if (masterMap.containsKey(consultantId)) {
                    SendMessage(masterMap.get(consultantId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
                if (userMap.containsKey(userId)) {
                    SendMessage(userMap.get(userId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
            }


        }else if (websocketRequestMsg.getType().equals(3)){
            //删除模型
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            Operating operating = room.deleteModel(websocketRequestMsg.getLocation());
            hotel.updateRoom(websocketRequestMsg.getRoomId(),room);
            Integer consultantId = room.getMembers().getConsultantId();
            Integer supervisorId = room.getMembers().getSupervisorId();
            Integer userId = room.getMembers().getUserId();
            if (mark.equals(0)) {
                //如果是用户摆放模型,通知督导师和咨询师

                if (masterMap.containsKey(consultantId)) {
                    SendMessage(masterMap.get(consultantId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
                if (masterMap.containsKey(supervisorId)) {
                    SendMessage(masterMap.get(supervisorId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
            }
            if (mark.equals(1)) {
                //如果是督导师摆放模型,通知用户和咨询师
                if (masterMap.containsKey(consultantId)) {
                    SendMessage(masterMap.get(consultantId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
                if (userMap.containsKey(userId)) {
                    SendMessage(userMap.get(userId), JSON.toJSONString(
                            new CommonResponse<>(100,"推送成功",operating)));
                }
            }


        }else if (websocketRequestMsg.getType().equals(4)){
            //移除房间
            hotel.removeRoom(websocketRequestMsg.getRoomId(),websocketRequestMsg.getUserId());
            Members members = websocketRequestMsg.getMembers();

            TbAdvisoryEntity tbAdvisoryEntity = new TbAdvisoryEntity();
            tbAdvisoryEntity.setAppId(websocketRequestMsg.getAppId());
            tbAdvisoryEntity.setUserId(members.getUserId());
            tbAdvisoryEntity.setMasterConsultantId(members.getConsultantId());
            tbAdvisoryEntity.setMasterSupervisorId(members.getSupervisorId());
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            tbAdvisoryEntity.setAdTime(new Timestamp(calendar.getTime().getTime()));
            tbAdvisoryDao.save(tbAdvisoryEntity);

            CommonResponse<Room> response = new CommonResponse<>(600, "咨询已结束", null);
            String res = JSON.toJSONString(response);
            if (masterMap.containsKey(members.getSupervisorId())){
                SendMessage(masterMap.get(members.getSupervisorId()),res);
            }
            if (masterMap.containsKey(members.getConsultantId())){
                SendMessage(masterMap.get(members.getConsultantId()),res);
            }
            if (userMap.containsKey(members.getUserId())){
                SendMessage(userMap.get(members.getUserId()),res);
            }

        }else if (websocketRequestMsg.getType().equals(5)){
            //加载房间
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            CommonResponse<Room> response = new CommonResponse<>(200, "加载成功", room);
            SendMessage(session,JSON.toJSONString(response));


        }else if (websocketRequestMsg.getType().equals(6)){
            //实时同步模型位置
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            if (null!=room) {
                CommonResponse response = new CommonResponse(200, "同步队列已经移除", null);
                SendMessage(session, JSON.toJSONString(response));
            }else {
                CommonResponse response = new CommonResponse(200, "同步失败,没有找到房间", null);
                SendMessage(session, JSON.toJSONString(response));
            }


        }else if (websocketRequestMsg.getType().equals(7)){
            //督导师查看可以进入的房间 (弃用)
            List<Room> room = hotel.findRoom(websocketRequestMsg.getUserId());
            CommonResponse<List<Room>> response = new CommonResponse<>(200, "获取成功", room);
            SendMessage(session,JSON.toJSONString(response));


        }else if (websocketRequestMsg.getType().equals(8)){
            //调试,查看所有房间
            CommonResponse response = new CommonResponse(200, "获取成功", hotel);
            SendMessage(session,JSON.toJSONString(response));


        }
    }

    /**
     * 出现错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        SendMessage(session,"=出现了错误=");
        error.printStackTrace();
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     */
    public static synchronized void SendMessage(Session session, String message) {
        try {
            if (session.isOpen()) {
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}













