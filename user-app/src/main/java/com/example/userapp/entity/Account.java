package com.example.userapp.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {

    private Integer id;

    private User user;

    private BigDecimal balance;
}
