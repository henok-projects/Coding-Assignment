package com.sample.demo.dto;


import lombok.Data;

import java.io.Serializable;
@Data
public class ChildDTO extends CommonDTO implements Serializable {
    private int id;
    private int paidAmount;
}
