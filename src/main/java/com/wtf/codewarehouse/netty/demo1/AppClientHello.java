package com.wtf.codewarehouse.netty.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @Author: WTF
 * @Date: 2021/2/3 13:54
 */
public class AppClientHello {

    public static void main(String[] args) throws InterruptedException {
        new AppClientHello("127.0.0.1",8081).run();
    }

    private final String host;
    private final int port;

    public AppClientHello(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException {
        //IO线程池
        EventLoopGroup group=new NioEventLoopGroup();
        //客户端辅助启动类
        Bootstrap bs=new Bootstrap();
        bs.group(group)
                //实例化一个channel
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host,port))
                //进行通道初始化配置
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //添加我们自定义的handler
                        ch.pipeline().addLast(new HandlerClientHello());
                    }
                });

        try {
            //连接到远程节点
            //发送消息到服务器端
            Scanner sc= new Scanner(System.in);
            ChannelFuture future=bs.connect().sync();
            while (true){
                System.out.printf("请输入：");
                String content=sc.next();
                future.channel().writeAndFlush(Unpooled.copiedBuffer(content, CharsetUtil.UTF_8));
//                future.channel().closeFuture().sync();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            group.shutdownGracefully().sync();
        }
    }
}
