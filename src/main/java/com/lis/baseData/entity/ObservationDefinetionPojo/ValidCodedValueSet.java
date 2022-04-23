/**
  * Copyright 2022 bejson.com 
  */
package com.lis.baseData.entity.ObservationDefinetionPojo;

import lombok.*;
import org.springframework.stereotype.Component;

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
public class ValidCodedValueSet {

    private String coding_code;
    private String coding_display;
    private String ex_inqltctr_value;
    private boolean ex_default_sign;

}