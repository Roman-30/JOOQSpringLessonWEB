package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableCreateDto {
    private Integer roomNumber;
    private Integer pareNumber;
    private Long lectureId;
    private Long subjectId;
}