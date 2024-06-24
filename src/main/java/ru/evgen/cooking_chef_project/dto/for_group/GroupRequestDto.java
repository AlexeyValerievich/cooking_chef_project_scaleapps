package ru.evgen.cooking_chef_project.dto.for_group;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель класса entity используемый в параметрах контроллера (request), " +
        "относящийся к группам университета")
public class GroupRequestDto {

    @Schema(description = "Id идентификатор")
    private long id;

    @Schema(description = "Группа университета")
    private String number;

    @Schema(description = "Количество студентов в группе")
    private int quantity;
}
