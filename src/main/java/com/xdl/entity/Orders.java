package com.xdl.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Orders {
    private Integer id;
    private String name;
    private Customer customer;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
