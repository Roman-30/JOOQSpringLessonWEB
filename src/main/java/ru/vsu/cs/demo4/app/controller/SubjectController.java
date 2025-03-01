package ru.vsu.cs.demo4.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.demo4.app.service.SubjectService;

@RestController
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
}
