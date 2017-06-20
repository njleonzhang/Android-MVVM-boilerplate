package com.leon.mvvm.ui.main.home.model;

/**
 * Created by leon on 2017/6/5.
 */

public class HomeTestBean {

    /**
     * id : 4610936132531413628
     * type : help
     * content : 请问我的快递门卫帮我代收了吗？
     * unread_cnt : 0
     */

    private String id;
    private String type;
    private String content;
    private int unread_cnt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUnread_cnt() {
        return unread_cnt;
    }

    public void setUnread_cnt(int unread_cnt) {
        this.unread_cnt = unread_cnt;
    }
}
