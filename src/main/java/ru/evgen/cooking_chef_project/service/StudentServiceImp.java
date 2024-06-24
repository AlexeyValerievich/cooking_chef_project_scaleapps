package ru.evgen.cooking_chef_project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evgen.cooking_chef_project.dto.for_student.StudentRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;
import ru.evgen.cooking_chef_project.entity.Student;
import ru.evgen.cooking_chef_project.mapping.StudentMapper;
import ru.evgen.cooking_chef_project.repository.GroupRepository;
import ru.evgen.cooking_chef_project.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;

    @Override
    public void addStudent(StudentRequestDto studentRequestDto, long universityGroupsId) {
        log.info("Adding a new student {} group {}", studentRequestDto.getSurname(), universityGroupsId);

        Group group = groupRepository.findById(universityGroupsId).get();
        studentRequestDto.setGroup(group);
        Student students = studentMapper.toEntityRequest(studentRequestDto);
        studentRepository.save(students);

        log.info("Student {} saved to the database", students.getSurname());
    }

    @Override
    public List<StudentResponsDto> getOneStudentGroup(long groupsId) {
        Group group = groupRepository.getById(groupsId);
        List<Student> students = group.getStudents();
        return studentMapper.toDtoResponsList(students);
}

    @Override
    public void deleteStudent(long groupsId, int studentId) {

        Group group = groupRepository.getById(groupsId);
        String name = null;

        for(Student st: group.getStudents()){
            if(st.getId() == studentId){
                name = st.getSurname();
            }
        }

        log.info("Студент {} удален из группы {}", name, groupsId);

        studentRepository.deleteById(studentId);


    }
}
