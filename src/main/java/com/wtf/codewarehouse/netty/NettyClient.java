package com.wtf.codewarehouse.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/8/22 9:55
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        NioEventLoopGroup group=new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });

        Channel channel=bootstrap.connect("127.0.0.1",8000).channel();

        while(true){
            channel.writeAndFlush(new Date()+" : hello netty");
            Thread.sleep(2000);
        }
    }
}
