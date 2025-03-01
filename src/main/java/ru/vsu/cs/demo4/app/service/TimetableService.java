package ru.vsu.cs.demo4.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.demo4.app.mapper.TimetableMapper;
import ru.vsu.cs.demo4.app.repository.TimetableRepository;

@Service
@RequiredArgsConstructor
public class TimetableService {
    private final TimetableRepository timetableRepository;
    private final TimetableMapper timetableMapper;
}
