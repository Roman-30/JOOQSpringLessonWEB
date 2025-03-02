package ru.vsu.cs.demo4.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vsu.cs.demo4.app.dto.LecturerBaseDto;
import ru.vsu.cs.demo4.app.dto.LecturerCreateDto;
import ru.vsu.cs.demo4.app.dto.LecturerUpdateDto;
import ru.vsu.cs.demo4.app.filter.LecturerFilter;
import ru.vsu.cs.demo4.app.mapper.LecturerMapper;
import ru.vsu.cs.demo4.app.model.Lecturer;
import ru.vsu.cs.demo4.app.repository.LecturerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;

    public LecturerBaseDto getLecturerById(Long id) {
        return lecturerMapper.modelToBaseDto(
                lecturerRepository.findLecturerById(id)
        );
    }

    public LecturerBaseDto createLecturer(LecturerCreateDto lecturerCreateDto) {
        var lecture = saveLecturer(
                lecturerMapper.createToModel(lecturerCreateDto)
        );

        return lecturerMapper.modelToBaseDto(lecture);
    }

    private Lecturer saveLecturer(Lecturer lecture) {
        return lecturerRepository.saveLecturer(lecture);
    }

    public void deleteLecturerById(Long id) {
        var lecturer = lecturerRepository.findLecturerById(id);

        lecturerRepository.deleteLecturerById(id);
    }

    public LecturerBaseDto updateLecturerById(Long id, LecturerUpdateDto lecturerUpdateDto) {
        var lecturer = lecturerRepository.findLecturerById(id);

        lecturerMapper.updateModel(lecturer, lecturerUpdateDto);

        return lecturerMapper.modelToBaseDto(lecturer);
    }

    public List<LecturerBaseDto> findAllLecturers() {
        return lecturerMapper.modelListToBaseDtoList(
                lecturerRepository.findAllLecturers()
        );
    }

    public Page<LecturerBaseDto> findLecturerByFilter(LecturerFilter lecturerFilter, Pageable pageable) {
        Page<Lecturer> lecturerPages = lecturerRepository.findLecturers(lecturerFilter, pageable);


        return new PageImpl<>(
                lecturerMapper.modelListToBaseDtoList(lecturerPages.getContent()),
                lecturerPages.getPageable(),
                lecturerPages.getTotalElements()
        );
    }
}
