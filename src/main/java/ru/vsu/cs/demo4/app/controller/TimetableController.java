package ru.vsu.cs.demo4.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.demo4.app.dto.TimetableBaseDto;
import ru.vsu.cs.demo4.app.dto.TimetableCreateDto;
import ru.vsu.cs.demo4.app.dto.TimetableUpdateDto;
import ru.vsu.cs.demo4.app.service.TimetableService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timetable")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping("/{id}")
    public TimetableBaseDto getTimetableById(@PathVariable Long id) {
        return timetableService.getTimetableById(id);
    }

    @PostMapping
    public TimetableBaseDto createTimetable(@RequestBody TimetableCreateDto timetableCreateDto) {
        return timetableService.createTimetable(timetableCreateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimetableById(@PathVariable Long id) {
        timetableService.deleteTimetableById(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("/{id}")
    public TimetableBaseDto updateTimetableById(@PathVariable Long id, @RequestBody TimetableUpdateDto timetableUpdateDto) {
        return timetableService.updateTimetableById(id, timetableUpdateDto);
    }

    @GetMapping("/list")
    public List<TimetableBaseDto> findAllTimetables() {
        return timetableService.findAllTimetables();
    }
}
