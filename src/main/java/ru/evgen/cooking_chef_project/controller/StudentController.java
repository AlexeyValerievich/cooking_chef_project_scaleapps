package ru.evgen.cooking_chef_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;
import ru.evgen.cooking_chef_project.entity.Student;
import ru.evgen.cooking_chef_project.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
@Tag(name = "Student Controller",
        description = "Все методы для работы со студентами")
public class StudentController {

    private final StudentService studentService;

    @Operation(description = "Добавление студента в группу")
    @PostMapping("/{university_groups_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentRequestDto studentRequestDto,
                           @PathVariable long university_groups_id){
        studentService.addStudent(studentRequestDto, university_groups_id);
    }

    @Operation(description = "Показать всех студентов в группе")
    @GetMapping("/{id}")
    public List<StudentResponsDto> getOneStudentGroup(@Parameter(description = "Id группы университета")
                                                          @PathVariable int id){
        return studentService.getOneStudentGroup(id);
    }

    @Operation(description = "Удаление студента из группы")
    @DeleteMapping("{groupId}/{studentId}")
    public void deleteStudent(@PathVariable long groupId, @PathVariable int studentId){
        studentService.deleteStudent(groupId, studentId);

    }

}
