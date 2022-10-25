package ru.java.relex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    private String filepath;
    private String operation;
}
