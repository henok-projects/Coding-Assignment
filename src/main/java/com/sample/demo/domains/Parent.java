package com.sample.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Parent {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "totalAmount")
    private int totalAmount;

    public Parent() {}
}
