package ru.evgen.cooking_chef_project.mapping;

import org.mapstruct.Mapper;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;
import ru.evgen.cooking_chef_project.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentRequestDto toDtoRequest(Student student);

    StudentResponsDto toDtoResponse(Student student);

    List<StudentResponsDto> toDtoResponsList(List<Student> studentsList);

    Student toEntityRequest(StudentRequestDto studentRequestDto);

    Student toEntityResponse(StudentResponsDto studentResponsDto);

    List<Student> toEntityList(List<StudentResponsDto> studentResponsDtoList);
}
