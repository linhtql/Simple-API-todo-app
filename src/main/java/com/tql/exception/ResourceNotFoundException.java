package com.tql.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public  class ResourceNotFoundException extends RuntimeException{

    private String resourceName ;
    private String fieldName;
    private Long fieldValueLong;
    private String fieldValueStr;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValueLong) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueLong));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueLong = fieldValueLong;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueStr) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueStr));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueStr = fieldValueStr;
    }

}
