package com.sample.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parentId")
    private long parentId;

    @Column(name = "paidAmount")
    private int paidAmount;

    public Child() {}
}
