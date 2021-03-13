package com.wtf.codewarehouse.funny;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author wangtengfei
 * @since 2020/12/17 15:17
 */

public class Boom {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();// 创建Robot对象

        int times = 10; //轰炸的次数，可以自己修改
        int time = 500; //两次轰炸之间相隔的时间，单位为毫秒

        robot.delay(3000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒

        for (int j = 0; j < times; j++) {//循环次数
            // 以下两行按下了ctrl+v，完成粘贴功能
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
            robot.delay(time);// 延迟发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
            robot.keyPress(KeyEvent.VK_ENTER);// 回车
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}
