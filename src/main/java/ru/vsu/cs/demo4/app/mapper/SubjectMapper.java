package ru.vsu.cs.demo4.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import ru.vsu.cs.demo4.app.dto.SubjectBaseDto;
import ru.vsu.cs.demo4.app.dto.SubjectCreateDto;
import ru.vsu.cs.demo4.app.dto.SubjectUpdateDto;
import ru.vsu.cs.demo4.app.model.Subject;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectMapper {
    Subject baseDtoToModel(SubjectBaseDto subjectBaseDto);

    SubjectBaseDto modelToBaseDto(Subject subject);

    Subject createToModel(SubjectCreateDto subjectCreateDto);

    void updateModel(@MappingTarget Subject subject, SubjectUpdateDto subjectUpdateDto);

    List<SubjectBaseDto> modelListToBaseDtoList(List<Subject> subjectList);
}
