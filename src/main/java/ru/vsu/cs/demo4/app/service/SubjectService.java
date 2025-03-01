package ru.vsu.cs.demo4.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.demo4.app.mapper.SubjectMapper;
import ru.vsu.cs.demo4.app.repository.SubjectRepository;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
}
