package com.example.money.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "money_entity")
public class MoneyEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "amount")
    private Long amount;


}