package ru.vsu.cs.demo4.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerBaseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
