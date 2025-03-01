package ru.vsu.cs.demo4.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.vsu.cs.demo4.app.dto.TimetableBaseDto;
import ru.vsu.cs.demo4.app.dto.TimetableCreateDto;
import ru.vsu.cs.demo4.app.dto.TimetableUpdateDto;
import ru.vsu.cs.demo4.app.model.Timetable;

import java.util.List;

@Mapper(componentModel = "spring")

public interface TimetableMapper {
    Timetable baseDtoToModel(TimetableBaseDto timetableBaseDto);

    TimetableBaseDto modelToBaseDto(Timetable timetable);

    Timetable createToModel(TimetableCreateDto timetableCreateDto);

    void updateModel(@MappingTarget Timetable timetable, TimetableUpdateDto timetableUpdateDto);

    List<TimetableBaseDto> modelListToBaseDtoList(List<Timetable> timetableList);
}