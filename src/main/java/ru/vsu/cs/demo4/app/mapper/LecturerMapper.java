package ru.vsu.cs.demo4.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.vsu.cs.demo4.app.dto.LecturerBaseDto;
import ru.vsu.cs.demo4.app.dto.LecturerCreateDto;
import ru.vsu.cs.demo4.app.dto.LecturerUpdateDto;
import ru.vsu.cs.demo4.app.model.Lecturer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerMapper {
    Lecturer baseDtoToModel(LecturerBaseDto lecturerBaseDto);

    LecturerBaseDto modelToBaseDto(Lecturer lecturer);

    Lecturer createToModel(LecturerCreateDto lecturerCreateDto);

    void updateModel(@MappingTarget Lecturer lecturer, LecturerUpdateDto lecturerUpdateDto);

    List<LecturerBaseDto> modelListToBaseDtoList(List<Lecturer> lecturerList);
}
