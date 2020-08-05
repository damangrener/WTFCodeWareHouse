package com.wtf.codewarehouse.serialization;

import java.io.Serializable;

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
}
