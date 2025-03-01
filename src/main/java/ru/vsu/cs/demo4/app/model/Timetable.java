package ru.vsu.cs.demo4.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Timetable {
    private Long id;
    private Integer roomNumber;
    private Integer pareNumber;
    private Long lectureId;
    private Long subjectId;
}
