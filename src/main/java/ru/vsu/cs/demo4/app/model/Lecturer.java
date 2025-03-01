package ru.vsu.cs.demo4.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lecturer {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
