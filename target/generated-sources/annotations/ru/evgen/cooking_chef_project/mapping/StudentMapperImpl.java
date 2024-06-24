package ru.evgen.cooking_chef_project.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.evgen.cooking_chef_project.dto.for_student.StudentRequestDto;
import ru.evgen.cooking_chef_project.dto.for_student.StudentResponsDto;
import ru.evgen.cooking_chef_project.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T21:01:05+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentRequestDto toDtoRequest(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentRequestDto studentRequestDto = new StudentRequestDto();

        studentRequestDto.setId( student.getId() );
        studentRequestDto.setSurname( student.getSurname() );
        studentRequestDto.setGroup( student.getGroup() );

        return studentRequestDto;
    }

    @Override
    public StudentResponsDto toDtoResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponsDto studentResponsDto = new StudentResponsDto();

        studentResponsDto.setId( student.getId() );
        studentResponsDto.setSurname( student.getSurname() );

        return studentResponsDto;
    }

    @Override
    public List<StudentResponsDto> toDtoResponsList(List<Student> studentsList) {
        if ( studentsList == null ) {
            return null;
        }

        List<StudentResponsDto> list = new ArrayList<StudentResponsDto>( studentsList.size() );
        for ( Student student : studentsList ) {
            list.add( toDtoResponse( student ) );
        }

        return list;
    }

    @Override
    public Student toEntityRequest(StudentRequestDto studentRequestDto) {
        if ( studentRequestDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentRequestDto.getId() );
        student.setSurname( studentRequestDto.getSurname() );
        student.setGroup( studentRequestDto.getGroup() );

        return student;
    }

    @Override
    public Student toEntityResponse(StudentResponsDto studentResponsDto) {
        if ( studentResponsDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentResponsDto.getId() );
        student.setSurname( studentResponsDto.getSurname() );

        return student;
    }

    @Override
    public List<Student> toEntityList(List<StudentResponsDto> studentResponsDtoList) {
        if ( studentResponsDtoList == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( studentResponsDtoList.size() );
        for ( StudentResponsDto studentResponsDto : studentResponsDtoList ) {
            list.add( toEntityResponse( studentResponsDto ) );
        }

        return list;
    }
}
