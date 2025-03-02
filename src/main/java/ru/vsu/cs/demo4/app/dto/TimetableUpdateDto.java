package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TimetableUpdateDto extends TimetableCreateDto {

}
