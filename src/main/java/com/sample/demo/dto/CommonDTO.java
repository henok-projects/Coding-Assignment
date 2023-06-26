package com.sample.demo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CommonDTO implements Serializable {
    private String sender;

    private String receiver;

    private Integer totalAmount;

}
