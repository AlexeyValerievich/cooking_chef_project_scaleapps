package ru.evgen.cooking_chef_project.dto.for_student;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.evgen.cooking_chef_project.entity.Group;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель класса entity используемый в параметрах контроллера (request)," +
        "относящийся к студентам")
public class StudentRequestDto {

    @Schema(description = "Id идентификатор")
    private Long id;

    @Schema(description = "ФИО студента")
    private String surname;

    private Group group;
}
