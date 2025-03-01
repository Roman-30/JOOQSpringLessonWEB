package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TimetableUpdateDto extends TimetableCreateDto{
    private Integer roomNumber;
    private Integer pareNumber;
    private Long lectureId;
    private Long subjectId;
}
