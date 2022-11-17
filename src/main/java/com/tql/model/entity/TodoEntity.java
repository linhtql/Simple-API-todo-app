package com.tql.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Boolean done;


}
