package com.xdl.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Customer {
    private Integer id;
    private String name;
    private Set<Orders> orders;
}
