package com.wtf.codewarehouse.util.rank.listrank;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 对排过序的list赋值排名
 * @author wangtengfei
 * @since 2020/11/24 15:08
 */
@Data
@AllArgsConstructor
public class RankDemo {

    private Integer id;
    private String name;
    private Integer url;

    public static void main(String[] args) {
        RankDemo menu=new RankDemo(1,"a",null);
        RankDemo menu1=new RankDemo(1,"b",null);
        RankDemo menu2=new RankDemo(2,"c",null);
        RankDemo menu3=new RankDemo(3,"d",null);
        RankDemo menu4=new RankDemo(4,"e",null);
        RankDemo menu5=new RankDemo(6,"e",null);
        RankDemo menu6=new RankDemo(8,"e",null);
        List<RankDemo> menus=new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);
        menus.add(menu6);

        menus.get(0).setUrl(1);
        for (int i = 1; i < menus.size(); i++) {
            if(i>=1&&menus.get(i).getId().equals(menus.get(i-1).getId())){
                menus.get(i).setUrl(menus.get(i-1).getUrl());
            }else{
                menus.get(i).setUrl(i);
            }
        }

        menus.forEach(x-> System.out.println(x));
    }
}
