package com.tql.model.payload;

import lombok.Data;

@Data
public class TodoDTO {

    private Long id;
    private String name;
    private String description;
    private Boolean done;
}
