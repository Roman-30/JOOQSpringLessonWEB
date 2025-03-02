package ru.vsu.cs.demo4.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.demo4.app.dto.SubjectBaseDto;
import ru.vsu.cs.demo4.app.dto.SubjectCreateDto;
import ru.vsu.cs.demo4.app.dto.SubjectUpdateDto;
import ru.vsu.cs.demo4.app.mapper.SubjectMapper;
import ru.vsu.cs.demo4.app.model.Subject;
import ru.vsu.cs.demo4.app.repository.SubjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectBaseDto getSubjectById(Long id) {
        return subjectMapper.modelToBaseDto(
                subjectRepository.findSubjectById(id)
        );
    }

    public SubjectBaseDto createSubject(SubjectCreateDto subjectCreateDto) {
        var subject = saveSubject(
                subjectMapper.createToModel(subjectCreateDto)
        );

        return subjectMapper.modelToBaseDto(subject);
    }

    private Subject saveSubject(Subject subject) {
        return subjectRepository.saveSubject(subject);
    }

    public void deleteSubjectById(Long id) {
        var subject = subjectRepository.findSubjectById(id);

        subjectRepository.deleteSubjectById(id);
    }

    public SubjectBaseDto updateSubjectById(Long id, SubjectUpdateDto subjectUpdateDto) {
        var subject = subjectRepository.findSubjectById(id);

        subjectMapper.updateModel(subject, subjectUpdateDto);

        return subjectMapper.modelToBaseDto(subject);
    }

    public List<SubjectBaseDto> findAllSubjects() {
        return subjectMapper.modelListToBaseDtoList(
                subjectRepository.findAllSubjects()
        );
    }
}
