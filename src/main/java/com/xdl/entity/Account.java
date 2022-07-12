package com.xdl.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Account {
    private Integer id;
    private String name;
    private Set<Course> courses;
}
