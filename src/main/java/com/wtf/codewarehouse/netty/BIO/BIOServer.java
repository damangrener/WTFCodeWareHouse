package com.wtf.codewarehouse.netty.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: WTF
 * @Date: 2021/2/1 19:26
 */
public class BIOServer {

    public static void main(String[] args) {
        BIOServer.multiThreadServer();

    }

    /**
     * 【多线程BIO】
     * 【Question】
     * 1.如何能使BIO处理多个客户端请求呢？
     * 一个连接一个线程
     * 多线程BIO虽然解决了单线程BIO无法处理并发的弱点，
     * 但是，如果大量的连接请求到我们的服务器上却不发送消息，
     * 连接数越多就会对服务器造成极大的压力。
     * 所以，如果这种不活跃的线程比较多，我们应该 采取单线程的解决方案，
     * 但是单线程又无法处理并发，这就陷入了矛盾的状态，
     * 于是就有了NIO
     * 【】
     */
    static void multiThreadServer() {
        try {
            ServerSocket serverSocket=new ServerSocket(8081);
            System.out.println("服务器已启动并监听8080端口");
            while(true) {
                System.out.println();
                System.out.println("服务器正在等待连接。。。");
                Socket socket=serverSocket.accept();
                byte[] buffer=new byte[1024];
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("服务器已接收到连接请求...");
                        System.out.println();
                        System.out.println("服务器正在等待数据...");
                        try {
                            socket.getInputStream().read(buffer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("服务器已经接收到数据");
                        System.out.println();
                        String content = new String(buffer);
                        System.out.println("接收到的数据:" + content);
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 【单线程BIO】
     * 经典的JavaBIO实现的简易的网络通信程序。
     * 当我们的服务器接收到一个连接后，并且没有接收到客户端
     * 发送的数据时，会阻塞在read()方法，此时如果再来一个
     * 客户端请求，服务端是无法响应的。
     * <p>
     * 【byte[] buffer放在循环外出现的问题】1.客户端第二次发的消息比第一次短，
     * read方法会用第二次的消息从头覆盖第一次，覆盖不完全。
     */
    static void singleThreadServer() {
        byte[] buffer = new byte[1024];
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器已启动并监听8080端口");
//            int capacity = 0;
            while (true) {
                System.out.println();
                System.out.println("服务器正在等待连接...");
                //阻塞1：等待连接时阻塞
                Socket socket = serverSocket.accept();
//                System.out.println(JSON.toJSONString(serverSocket));
//                System.out.println(JSON.toJSONString(socket));
                System.out.println("服务器已收到连接请求");
                System.out.println();
                System.out.println("服务器正在等待数据");
                System.out.println(buffer);
                String content = new String(buffer, "utf-8");
                //阻塞2：等待数据时阻塞
                socket.getInputStream().read(buffer);
//                System.out.println(content.split(";")[1]);
//                socket.getInputStream().read(buffer,0,Integer.parseInt(content.split(";")[1]));
                System.out.println("服务器已经接收到数据");
//                System.out.println(socket.getInputStream().read());
//                capacity+=buffer.length ;
                System.out.println("buffer" + buffer);
                System.out.println("接收到的数据:" + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
