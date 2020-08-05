package com.wtf.codewarehouse.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangtengfei
 * @since 2020/8/4 15:37
 */
public class SerialTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 基本步骤：
         * 1.对象实体类实现Serializable标记接口
         * 2.创建序列化输出流对象ObjectOutputStream，该对象的创建依赖于其他输出流对象，
         *  通常我们将对象序列化为文件存储，所以这里用文件相关的输出流对象FileOutputStream
         * 3.通过ObjectOutPutStream的writeObject()方法将随想序列化为文件
         * 4.关闭流，采用JDK1.7开始的try-with-resources 自动关闭
         */
        User user=new User("王某飞","123456",22);
        Menu menu=new Menu(1,"菜单1","/menu1");
        Menu menu2=new Menu(2,"菜单2","/menu2");
        List<Menu> menus=new ArrayList<>(2);
        menus.add(menu);
        menus.add(menu2);
        user.setMenus(menus);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\user"))) {
        os.writeObject(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        //
        TimeUnit.SECONDS.sleep(5);

        /**
         * 基本步骤：
         * 1. 创建输入流对象ObjectInputStream，同样依赖于其他输入流对象，这里是文件输入流FileInputStream
         * 2. 通过ObjectInputStream的readObject()方法，将文件中的对象读取到内存
         * 3. 关闭流
         */
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\user"))) {
            User result=(User) is.readObject();
            System.out.println(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
