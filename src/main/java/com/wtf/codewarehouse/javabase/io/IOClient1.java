package com.wtf.codewarehouse.javabase.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author wangtengfei
 * @since 2020/8/21 14:51
 */
public class IOClient1 {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket=new Socket("127.0.0.1",8000);
                while(true){
                    socket.getOutputStream().write(("  hello IO").getBytes());
                    int len;
                    byte[] data = new byte[1024];
                    InputStream inputStream = socket.getInputStream();
                    // (3) 按字节流方式读取数据
                    while ((len = inputStream.read(data)) != -1) {
                        System.out.println(new String(data, 0, len));
                    }
                    Thread.sleep(500);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
