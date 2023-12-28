package com.example.pvi_lab16;

import java.io.IOException;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websockets")
public class Websockets extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        try{
            while(true){
                Thread.sleep(2000);
                session.getBasicRemote().sendText(format.format(new Date()));
            }
        }
        catch( IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}