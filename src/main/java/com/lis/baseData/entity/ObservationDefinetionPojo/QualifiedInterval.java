/**
  * Copyright 2022 bejson.com 
  */
package com.lis.baseData.entity.ObservationDefinetionPojo;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Auto-generated: 2022-04-22 11:11:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
@ToString
public class QualifiedInterval {

    private String ex_devicedefinition_id;
    private String context_coding_code;
    private String context_coding_display;
    private String range_high_code;
    private String range_high_value;
    private String range_high_unit;
    private String range_low_code;
    private String range_low_value;
    private String range_low_unit;
    private String category;
    private String age_high_code;
    private String age_high_value;
    private String age_high_unit;
    private String age_low_code;
    private String age_low_value;
    private String age_low_unit;
    private List<AppliesTo> appliesTo;
    private String gender;
    private String gestationalAge_high_code;
    private String gestationalAge_high_value;
    private String gestationalAge_high_unit;
    private String gestationalAge_low_code;
    private String gestationalAge_low_value;
    private String gestationalAge_low_unit;
    private String ex_condition_code;
    private String ex_condition_name;
    private String ex_collection_ocas_code;

}