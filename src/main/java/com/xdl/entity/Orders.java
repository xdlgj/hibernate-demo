package com.xdl.entity;

import lombok.Data;

@Data
public class Orders {
    private Integer id;
    private String name;
    private Customer customer;
}
