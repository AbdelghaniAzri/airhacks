package com.airhacks.socks;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author airhacks.com
 */
@ServerEndpoint("/hello")
public class HelloEndpoint {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //System.out.println("Opening: " + session);
    }

    @OnMessage
    public void message(String msg) {
        System.out.println("message " + msg);
        try {
            this.session.getBasicRemote().sendText("ping: " + msg);
        } catch (IOException ex) {
            Logger.getLogger(HelloEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
