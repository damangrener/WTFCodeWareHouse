package com.wtf.codewarehouse.javabase.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/8/21 14:51
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket=new Socket("127.0.0.1",8000);
                while(true){
                    socket.getOutputStream().write((new Date()+" : hello IO").getBytes());
                    Thread.sleep(2000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
