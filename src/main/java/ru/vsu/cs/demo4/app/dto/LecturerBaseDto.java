package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerBaseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;

    private Integer allExperience;
    private Integer currentExperience;

    private LocalDateTime startWork;
    private LocalDateTime startProfession;
}
