package ru.vsu.cs.demo4.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private Long id;
    private String name;
    private String code;
    private Integer hourCount;
}
