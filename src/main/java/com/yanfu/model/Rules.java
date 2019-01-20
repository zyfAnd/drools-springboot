package com.yanfu.model;

import java.util.Date;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/20.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
public class Rules {
    private Integer id;
    private String rule;
    private String name;
    private Date create_time;
    private Date update_time;
    private Integer visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}
