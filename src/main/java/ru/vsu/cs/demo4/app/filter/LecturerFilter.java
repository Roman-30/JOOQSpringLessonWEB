package ru.vsu.cs.demo4.app.filter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LecturerFilter {
    private String keyValue;

    private String name;
    private String surname;
    private LocalDateTime startWork;
    private LocalDateTime startProfession;
}
