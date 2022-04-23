package com.lis.baseModel.entity;


public class Temp {

    private int ID;
    private String 指标代码;
    private String 中文名;
    private String 标本编码;
    private String 检验标本;
    private String 试管编码;
    private String 试管名称;
    private String 标本部位编码;
    private String 标本部位;
    private String 采集方法编码;
    private String 采集方法;
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    public void set指标代码(String 指标代码) {
        this.指标代码 = 指标代码;
    }
    public String get指标代码() {
        return 指标代码;
    }

    public void set中文名(String 中文名) {
        this.中文名 = 中文名;
    }
    public String get中文名() {
        return 中文名;
    }

    public void set标本编码(String 标本编码) {
        this.标本编码 = 标本编码;
    }
    public String get标本编码() {
        return 标本编码;
    }

    public void set检验标本(String 检验标本) {
        this.检验标本 = 检验标本;
    }
    public String get检验标本() {
        return 检验标本;
    }

    public void set试管编码(String 试管编码) {
        this.试管编码 = 试管编码;
    }
    public String get试管编码() {
        return 试管编码;
    }

    public void set试管名称(String 试管名称) {
        this.试管名称 = 试管名称;
    }
    public String get试管名称() {
        return 试管名称;
    }

    public void set标本部位编码(String 标本部位编码) {
        this.标本部位编码 = 标本部位编码;
    }
    public String get标本部位编码() {
        return 标本部位编码;
    }

    public void set标本部位(String 标本部位) {
        this.标本部位 = 标本部位;
    }
    public String get标本部位() {
        return 标本部位;
    }

    public void set采集方法编码(String 采集方法编码) {
        this.采集方法编码 = 采集方法编码;
    }
    public String get采集方法编码() {
        return 采集方法编码;
    }

    public void set采集方法(String 采集方法) {
        this.采集方法 = 采集方法;
    }
    public String get采集方法() {
        return 采集方法;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "ID=" + ID +
                ", 指标代码='" + 指标代码 + '\'' +
                ", 中文名='" + 中文名 + '\'' +
                ", 标本编码='" + 标本编码 + '\'' +
                ", 检验标本='" + 检验标本 + '\'' +
                ", 试管编码='" + 试管编码 + '\'' +
                ", 试管名称='" + 试管名称 + '\'' +
                ", 标本部位编码='" + 标本部位编码 + '\'' +
                ", 标本部位='" + 标本部位 + '\'' +
                ", 采集方法编码='" + 采集方法编码 + '\'' +
                ", 采集方法='" + 采集方法 + '\'' +
                '}';
    }
}