package com.lis.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Infos  extends PublicResult{

    private Info info;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info {
        private String name;
        private String avatar;
        private List<String> roles;
        private String token;
    }

}




