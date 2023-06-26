package com.sample.demo.dto;

import lombok.Data;

import java.io.Serializable;

public class ParentDTO extends CommonDTO implements Serializable {

    private int id;

    private String sender;

    private String receiver;

    private int totalAmount;

    public ParentDTO(String sender, String receiver, int totalAmount, int totalPaidAmount, int id, String sender1, String receiver1, int totalAmount1) {
        super(sender, receiver, totalAmount, totalPaidAmount);
        this.id = id;
        this.sender = sender1;
        this.receiver = receiver1;
        this.totalAmount = totalAmount1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
