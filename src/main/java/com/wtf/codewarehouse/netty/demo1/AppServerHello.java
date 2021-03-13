package com.wtf.codewarehouse.netty.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: WTF
 * @Date: 2021/2/3 14:19
 */
public class AppServerHello {

    private int port;

    public AppServerHello(int port)
    {
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup group=new NioEventLoopGroup();
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new HandlerServerHello());
                    }
                });

        try {
            ChannelFuture future=serverBootstrap.bind().sync();
            System.out.println("在"+future.channel().localAddress()+"上开启监听");
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new AppServerHello(8080).run();
    }
}
