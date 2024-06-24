package ru.evgen.cooking_chef_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.evgen.cooking_chef_project.entity.Student;
import ru.evgen.cooking_chef_project.repository.StudentRepository;
import ru.evgen.cooking_chef_project.service.StudentServiceImp;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImpTest {

    @InjectMocks
    private StudentServiceImp studentServiceImp;

    @Mock
    private StudentRepository studentRepository;

    @Test
    void getSumStudents(){
        Student st1 = new Student();
        st1.setSurname("Alex");
        Student st2 = new Student();
        st2.setSurname("Sasha");

        Mockito.when(studentRepository.findAll()).thenReturn(List.of(st1, st2));

        int sumOfStudent = studentServiceImp.getSumStudents();
        Assertions.assertEquals(9, sumOfStudent);
    }
}
