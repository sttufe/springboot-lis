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
public class ObservationDefinetionJSON {
    private String id;
    private String code_coding_code;
    private String code_coding_display;
    private String quantitativeDetails_unit_code;
    private String quantitativeDetails_unit_display;
    private int quantitativeDetails_decimalPrecision;
    private String quantitativeDetails_customaryUnit_code;
    private String quantitativeDetails_customaryUnit_display;
    private int quantitativeDetails_conversionFactor;
    private String method_coding_code;
    private String method_coding_display;
    private String ex_plcmach_specimen_id;
    private String preferredReportName;
    private String permittedDataType;
    private List<QualifiedInterval> qualifiedInterval;
    private List<ValidCodedValueSet> validCodedValueSet;
    private String ex_computing_content;
    private boolean ex_active;
    private String ex_note_text;
    private boolean ex_hr;




}