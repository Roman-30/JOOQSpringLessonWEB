package ru.vsu.cs.demo4.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.demo4.app.dto.SubjectBaseDto;
import ru.vsu.cs.demo4.app.dto.SubjectCreateDto;
import ru.vsu.cs.demo4.app.dto.SubjectUpdateDto;
import ru.vsu.cs.demo4.app.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public SubjectBaseDto getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public SubjectBaseDto createSubject(@RequestBody SubjectCreateDto subjectCreateDto) {
        return subjectService.createSubject(subjectCreateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubjectById(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("/{id}")
    public SubjectBaseDto updateSubjectById(@PathVariable Long id, @RequestBody SubjectUpdateDto subjectUpdateDto) {
        return subjectService.updateSubjectById(id, subjectUpdateDto);
    }

    @GetMapping("/list")
    public List<SubjectBaseDto> findAllSubjects() {
        return subjectService.findAllSubjects();
    }
}
