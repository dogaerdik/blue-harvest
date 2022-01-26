package com.blueharvest.account.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String surName;
}