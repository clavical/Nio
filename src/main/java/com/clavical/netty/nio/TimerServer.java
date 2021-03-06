package com.clavical.netty.nio;

import com.clavical.netty.bio.handler.TimeServerHandler;

import java.io.IOException;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class TimerServer {
    public static void main(String[] args) throws IOException{
        int port = 8080;
        if(args!=null && args.length>0){
            try {
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port " + port);
            Socket socket = server.accept();
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(server!=null){
                System.out.println("The time server close");
                server.close();
                server = null;

            }
        }
    }
}
