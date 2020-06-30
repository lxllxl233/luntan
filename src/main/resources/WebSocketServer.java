package com.xinli.xinli.websocket;

import com.alibaba.fastjson.JSON;
import com.xinli.xinli.response.CommonResponse;
import com.xinli.xinli.util.SnowflakeIdUtils;
import com.xinli.xinli.websocket.bean.Hotel;
import com.xinli.xinli.websocket.bean.Operating;
import com.xinli.xinli.websocket.bean.Room;
import com.xinli.xinli.websocket.bean.request.WebsocketRequestMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


@Component
@ServerEndpoint(value = "/ws/getLocation")
public class WebSocketServer {

    //定义组件
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<Session>();
    //此处是解决无法注入的关键
    private static ApplicationContext applicationContext;
    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
    }

    public static SnowflakeIdUtils idWorker = null;
    public static Hotel hotel;
    @PostConstruct
    public void init() {
        System.out.println("websocket 加载");
        idWorker = new SnowflakeIdUtils(3, 1);
        hotel = new Hotel();
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        SessionSet.add(session);
        int cnt = OnlineCount.incrementAndGet(); // 在线数加1
        System.out.println("有客户端连接");
        try {
            SendMessage(session,"{\"code\":200,\"msg\":\"connect success\"}");
        } catch (Exception e) {
            System.out.println("IO异常-->{}"+ e);
        }
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        SessionSet.remove(session);
        //在线数减一
        int cnt = OnlineCount.decrementAndGet();

    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String requestParam, Session session) {
        WebsocketRequestMsg websocketRequestMsg = JSON.parseObject(requestParam, WebsocketRequestMsg.class);
        if (websocketRequestMsg.getType().equals(0)){
            //创建房间
            long id = idWorker.nextId();
            Long aLong = hotel.addRoom(websocketRequestMsg.getUserId(), id, new Room(id, websocketRequestMsg.getMembers(), new ArrayList<>()));
            CommonResponse<Long> response = new CommonResponse<>(200, "创建成功", aLong>0?aLong:id);
            SendMessage(session,JSON.toJSONString(response));
        }else if (websocketRequestMsg.getType().equals(1)){
            //获取房间id
            Room room = hotel.getRoom(websocketRequestMsg.getUserId(),websocketRequestMsg.getMembers().getConsultantId());
            CommonResponse<Long> response = new CommonResponse<>(200, "获取成功", room.getRoomId());
            SendMessage(session,JSON.toJSONString(response));
        }else if (websocketRequestMsg.getType().equals(2)){
            //添加/修改模型
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            room.addAndUpdateModel(websocketRequestMsg.getLocation());
            hotel.updateRoom(websocketRequestMsg.getRoomId(),room);
        }else if (websocketRequestMsg.getType().equals(3)){
            //删除模型
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            room.deleteModel(websocketRequestMsg.getLocation());
            hotel.updateRoom(websocketRequestMsg.getRoomId(),room);
        }else if (websocketRequestMsg.getType().equals(4)){
            //移除房间
            hotel.removeRoom(websocketRequestMsg.getRoomId(),websocketRequestMsg.getUserId());
        }else if (websocketRequestMsg.getType().equals(5)){
            //加载房间
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            CommonResponse<Room> response = new CommonResponse<>(200, "加载成功", room);
            SendMessage(session,JSON.toJSONString(response));
        }else if (websocketRequestMsg.getType().equals(6)){
            //实时同步模型位置
            Room room = hotel.getRoom(websocketRequestMsg.getRoomId());
            if (null!=room) {
                List<Operating> operatingList = room.getOperatingList(websocketRequestMsg.getIndex());
                CommonResponse response = new CommonResponse(200, "同步成功", operatingList);
                SendMessage(session, JSON.toJSONString(response));
            }else {
                CommonResponse response = new CommonResponse(200, "同步失败,没有找到房间", null);
                SendMessage(session, JSON.toJSONString(response));
            }
        }else if (websocketRequestMsg.getType().equals(7)){
            //督导师查看可以进入的房间
            List<Room> room = hotel.findRoom(websocketRequestMsg.getUserId());
            CommonResponse<List<Room>> response = new CommonResponse<>(200, "获取成功", room);
            SendMessage(session,JSON.toJSONString(response));
        }else if (websocketRequestMsg.getType().equals(8)){
            //督导师查看可以进入的房间
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
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     */
    public static void BroadCastInfo(String message) throws IOException {
        for (Session session : SessionSet) {
            if(session.isOpen()){
                SendMessage(session, message);
            }
        }
    }

    /**
     * 指定Session发送消息
     */
    public static void SendMessage(String message,String sessionId) throws IOException {
        Session session = null;
        for (Session s : SessionSet) {
            if(s.getId().equals(sessionId)){
                session = s;
                break;
            }
        }
        if(session!=null){
            SendMessage(session, message);
        }
    }

}
