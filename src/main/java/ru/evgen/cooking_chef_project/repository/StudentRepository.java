package ru.evgen.cooking_chef_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.evgen.cooking_chef_project.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
