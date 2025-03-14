package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectBaseDto {
    private Long id;
    private String name;
    private String code;
    private Integer hourCount;
}
