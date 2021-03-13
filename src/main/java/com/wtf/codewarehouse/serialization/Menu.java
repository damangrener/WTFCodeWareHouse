package com.wtf.codewarehouse.serialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/8/4 16:35
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -1321891326047243289L;
    private Integer id;
    private String name;
    private String url;

    public Menu() {
    }

    public Menu(Integer id,String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Menu menu=new Menu(1,"a","url1");
        Menu menu1=new Menu(1,"b","url1");
        Menu menu2=new Menu(1,"c","url1");
        Menu menu3=new Menu(1,"d","url1");
        Menu menu4=new Menu(1,"e","url1");
        Menu menu5=new Menu(6,"e","url1");
        Menu menu6=new Menu(8,"e","url1");
        List<Menu> menus=new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);
        menus.add(menu6);
//        menus.get(0).setUrl("1");
        int j=1;
        for (int i = 0; i < menus.size(); i++) {
//            menus.get(i).setUrl(""+(i+1));
            if(i==0){
                menus.get(i).setUrl(""+(j));
                j++;
            }
            else if(menus.get(i).getId().equals(menus.get(i-1).getId())){
                menus.get(i).setUrl(menus.get(i-1).getUrl());
//                i--;
            }
            else{
                menus.get(i).setUrl(""+(j));
                j++;
            }

        }

        menus.forEach(x-> System.out.println(x));

    }
}
