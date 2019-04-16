package com.example.demow.common;

import lombok.Data;

@Data
public class Respone<T> {
    private Integer code;
    private T data;
    private String message;
}
