package ru.vsu.cs.demo4.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.demo4.app.dto.LecturerBaseDto;
import ru.vsu.cs.demo4.app.dto.LecturerCreateDto;
import ru.vsu.cs.demo4.app.dto.LecturerUpdateDto;
import ru.vsu.cs.demo4.app.filter.LecturerFilter;
import ru.vsu.cs.demo4.app.service.LecturerService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/lecturer")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping("/{id}")
    public LecturerBaseDto getLecturerById(@PathVariable Long id) {
       return lecturerService.getLecturerById(id);
    }

    @PostMapping
    public LecturerBaseDto createLecturer(@RequestBody LecturerCreateDto lecturerCreateDto) {
        return lecturerService.createLecturer(lecturerCreateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLecturerById(@PathVariable Long id) {
        lecturerService.deleteLecturerById(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("/{id}")
    public LecturerBaseDto updateLecturerById(@PathVariable Long id, @RequestBody LecturerUpdateDto lecturerUpdateDto) {
        return lecturerService.updateLecturerById(id, lecturerUpdateDto);
    }

    @GetMapping("/list")
    public List<LecturerBaseDto> findAllLecturers() {
        return lecturerService.findAllLecturers();
    }

    @PostMapping("/filter")
    public Page<LecturerBaseDto> findLecturerByFilter(
            @RequestBody(required = false) LecturerFilter lecturerFilter,
            @RequestParam Pageable pageable
            ) {
        return lecturerService.findLecturerByFilter(lecturerFilter, pageable);
    }
}
