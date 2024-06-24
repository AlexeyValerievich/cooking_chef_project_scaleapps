package ru.evgen.cooking_chef_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatFactDto {
    private String fact;
    private String length;
}
