package com.wtf.codewarehouse.wx;

import java.util.ArrayList;
import java.util.List;

public class AaInitWX {
    public static void main(String[] args) throws InterruptedException {
        List<String> myTools = new ArrayList<>(10);
        int i = 0;
        while (i < 20) {
            if (findTools("新工具的产生") || findTools("别人的安利")) {
                My.passion = 3;//我的三分钟热度来了
                myTools.add("新工具" + i);
                i++;
                if (0 == My.useTool(My.passion)) {
                    continue;
                }
            }
        }
    }

    static boolean findTools(String toolName) {
        return true;
    }

    static class My {
        //我的热度
        static int passion;
        static String status = "";

        static int useTool(int passion) {
            while (true) {
                //writeBlog();
                if ("懒了、倦了、疲惫了。。。 ".contains(My.status)) {
                    passion--;
                }
                if (0 == passion) {
                    return passion;
                }
            }
        }
    }
}
