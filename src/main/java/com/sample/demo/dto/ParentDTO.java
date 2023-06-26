package com.sample.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParentDTO extends CommonDTO implements Serializable {

    private int id;
    private Integer totalPaidAmount;
}
