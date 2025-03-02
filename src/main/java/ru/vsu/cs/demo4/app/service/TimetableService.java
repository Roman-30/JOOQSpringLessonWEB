package ru.vsu.cs.demo4.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.demo4.app.dto.TimetableBaseDto;
import ru.vsu.cs.demo4.app.dto.TimetableCreateDto;
import ru.vsu.cs.demo4.app.dto.TimetableUpdateDto;
import ru.vsu.cs.demo4.app.mapper.TimetableMapper;
import ru.vsu.cs.demo4.app.model.Timetable;
import ru.vsu.cs.demo4.app.repository.TimetableRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timetableRepository;
    private final TimetableMapper timetableMapper;

    public TimetableBaseDto getTimetableById(Long id) {
        return timetableMapper.modelToBaseDto(
                timetableRepository.findTimetableById(id)
        );
    }

    public TimetableBaseDto createTimetable(TimetableCreateDto timetableCreateDto) {
        var timetable = saveTimetable(
                timetableMapper.createToModel(timetableCreateDto)
        );

        return timetableMapper.modelToBaseDto(timetable);
    }

    private Timetable saveTimetable(Timetable timetable) {
        return timetableRepository.saveTimetable(timetable);
    }

    public void deleteTimetableById(Long id) {
        var timetable = timetableRepository.findTimetableById(id);

        timetableRepository.deleteTimetableById(id);
    }

    public TimetableBaseDto updateTimetableById(Long id, TimetableUpdateDto timetableUpdateDto) {
        var subject = timetableRepository.findTimetableById(id);

        timetableMapper.updateModel(subject, timetableUpdateDto);

        return timetableMapper.modelToBaseDto(subject);
    }

    public List<TimetableBaseDto> findAllTimetables() {
        return timetableMapper.modelListToBaseDtoList(
                timetableRepository.findAllTimetables()
        );
    }
}
