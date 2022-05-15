package com.lis.api.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route extends PublicResult{

    private List<Data> data;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
   public static class Data {
        private int id;
        private int pid;
        private String name;
        private String path;
        private String redirect;
        private String component;
        private String icon;
        private String key;
        private List<Data> children;}
}









