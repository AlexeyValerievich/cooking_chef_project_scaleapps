package ru.evgen.cooking_chef_project.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentResponsDto;
import ru.evgen.cooking_chef_project.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void addStudent(StudentRequestDto studentRequestDto, long universityGroupId);

    List<StudentResponsDto> getOneStudentGroup(long universityGroupId);

    void deleteStudent(long groupsId, int studentId);

}
