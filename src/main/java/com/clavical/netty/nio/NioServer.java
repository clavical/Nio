package com.clavical.netty.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NioServer {
    private int port = 8080;

    public static void main(String[] args) throws IOException {
        int port = 8080;
        //1.打开ServerSocketChannel,用于监听客户端的连接，他是客户端连接的父管道
        //ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
        //2.绑定监听端口，设置连接为非阻塞连接
        //acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),port));
        //acceptorSvr.configureBlocking(false);
        //3.创建Reactor线程，建立多路复用器并启动线程
        //Selector selector = Selector.open();
        //new Thread(new Reactor)
        //4.将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听ACCEPT事件
        //5.线程多路复用器在线程run方法的无限循环体内轮询准备就绪的key
        //6.多路复用器监听到有新的客户端接入，处理新的请求接入，完成TCP三次握手，建立物理链路
        //7.设置客户端链路为非阻塞模式
        //8.将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，读取客户端发送的网络消息
        //9.异步读取客户端请求消息到缓冲区
        //10.对ByteBuffer进行编码，如果有半包消息指针reset,继续读取后续的报文，将解码成功的消息封装城Task,投递到业务线程池当中，进行业务逻辑编排
        //11.将POJO对象encode成ByteBuffer，调用SocketChannel的异步write接口,将消息异步发送给客户端
        System.out.println(a());
    }

    public static int a(){
        int i = 0;
        try {
            return ++i;
        }finally {
            return ++i;
        }
    }
}
