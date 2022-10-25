package ru.java.relex.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Result {
    private Long maxValue;
    private Long minValue;
    private Long medianValue;
    private Long avgValue;
    private List<Long> ascSeq;
    private List<Long> descSeq;
}
