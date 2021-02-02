package com.wtf.codewarehouse.netty.BIO;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: WTF
 * @Date: 2021/2/1 19:31
 */
public class Consumer {
    public static void main(String[] args) throws IOException {
//        Consumer.a();
        Consumer.scannerSend();
    }

    static void a(){
        try {
            Socket socket=new Socket("127.0.0.1",8080);
            socket.getOutputStream().write("向服务器发数据".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 控制台输入
     * @throws IOException
     */
    static void scannerSend() throws IOException {
        Scanner sc= new Scanner(System.in);
        try {
            while (true){
                Socket socket=new Socket("127.0.0.1",8080);
                socket.setKeepAlive(false);
                System.out.println("客户端建立连接");
                StringBuffer message=new StringBuffer("客户端0说：");
                System.out.printf("请输入：");
                message.append(sc.next());
                String str=new String(message);
                socket.getOutputStream().write(str.getBytes());
//                socket.getOutputStream().write(new String(";3").getBytes(StandardCharsets.UTF_8));
                System.out.println("message:"+message);
//                System.out.printf("发song的消息："+socket.getInputStream().read());
                System.out.println("发song的消息："+new String(str.getBytes(),"utf-8")+"  byte[]："+str.getBytes());
                System.out.println("客户端关闭");
//                socket.getOutputStream().flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }
}
