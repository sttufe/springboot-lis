package com.lis.baseData.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@ToString
public class LabitemCopareObservation {
    private String 项目;
    private  String 指标;
}
