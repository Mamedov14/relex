package ru.java.relex.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String operation;
    private String response;

    @Override
    public String toString() {
        return operation + ": " + response;
    }
}
