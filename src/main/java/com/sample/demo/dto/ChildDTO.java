package com.sample.demo.dto;


import java.io.Serializable;
public class ChildDTO extends CommonDTO implements Serializable {
    private int id;

    private  int parentId;

    private int paidAmount;

    public ChildDTO(String sender, String receiver, int totalAmount, int totalPaidAmount, int id, int parentId, int paidAmount) {
        super(sender, receiver, totalAmount, totalPaidAmount);
        this.id = id;
        this.parentId = parentId;
        this.paidAmount = paidAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
}
