package com.lis.api.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteResult{

    private int code;
    private List<Data> data;
    private String message;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
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
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
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

    }

}









