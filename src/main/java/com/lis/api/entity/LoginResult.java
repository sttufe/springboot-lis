package com.lis.api.entity;

/**
 * Copyright 2022 bejson.com
 */
import java.util.List;

/**
 * Auto-generated: 2022-04-14 21:2:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LoginResult{

    private int code;
    private List<Data> data;
    private String message;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}

/**
 * Auto-generated: 2022-04-14 21:2:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
 class Data {

    private int id;
    private int pid;
    private String name;
    private String path;
    private String redirect;
    private String component;
    private String icon;
    private String key;
    private List<Children> children;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getPid() {
        return pid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    public String getRedirect() {
        return redirect;
    }

    public void setComponent(String component) {
        this.component = component;
    }
    public String getComponent() {
        return component;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIcon() {
        return icon;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
    public List<Children> getChildren() {
        return children;
    }

}

/**
 * Copyright 2022 bejson.com
 */

/**
 * Auto-generated: 2022-04-14 21:2:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
class Children {

    private int id;
    private int pid;
    private String name;
    private String path;
    private String redirect;
    private String component;
    private String icon;
    private String key;
    private List<Children> children;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getPid() {
        return pid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    public String getRedirect() {
        return redirect;
    }

    public void setComponent(String component) {
        this.component = component;
    }
    public String getComponent() {
        return component;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIcon() {
        return icon;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
    public List<Children> getChildren() {
        return children;
    }

}



