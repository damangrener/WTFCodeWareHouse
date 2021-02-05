package com.wtf.codewarehouse.netty.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WTF
 * @Date: 2021/2/3 10:12
 */
public class NIOServer {
    public static void main(String[] args) {
//        NIOServer.waitNotBlockServer();
        NIOServer.cacheSocketServer();
    }

    /**
     * 缓存Socket，轮询数据是否准备好
     */
    static void cacheSocketServer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        List<SocketChannel> socketChannelList = new ArrayList<>();
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (null == socketChannel) {
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(1000);
                } else {
                    System.out.println("当前接收到客户端请求连接...");
                    socketChannelList.add(socketChannel);
                }
                for (SocketChannel socket : socketChannelList
                ) {
                    socket.configureBlocking(false);
                    int effective = socket.read(byteBuffer);
                    if (0 != effective) {
                        byteBuffer.flip();
                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
                        System.out.println("接收到的消息：" + content);
                        byteBuffer.clear();
                    } else {
                        System.out.println("当前未收到客户端消息");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果要解决BIO的单线程服务器接收数据时阻塞，
     * 而无法接收新请求的问题，那么可以让服务器在
     * 等待数据实不进入阻塞状态。
     * 【问题】这种方式下，虽然在接受胡客户端消息时不会阻塞，
     * 但是又重新开始接收服务器请求，用户根本来不及输消息，
     * 服务器就转向接收别的客户端请求了，
     * 换言之，服务器丢了当前客户端的请求
     */
    static void waitNotBlockServer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            //java为非阻塞设置的类
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    //表示没人连接
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(5000);
                } else {
                    System.out.println("当前接到客户端请求连接...");
                    socketChannel.configureBlocking(false);
                    //切换模式
                    byteBuffer.flip();
                    int effective = socketChannel.read(byteBuffer);
                    if (effective != 0) {
                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
                        System.out.println(content);
                    } else {
                        System.out.println("当前未收到客户端消息");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
