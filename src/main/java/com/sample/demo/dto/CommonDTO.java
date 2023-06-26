package com.sample.demo.dto;


import java.io.Serializable;

public class CommonDTO implements Serializable {
    private String sender;

    private String receiver;

    private int totalAmount;

    private int totalPaidAmount;

    public CommonDTO(String sender, String receiver, int totalAmount, int totalPaidAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.totalPaidAmount = totalPaidAmount;
    }


}
