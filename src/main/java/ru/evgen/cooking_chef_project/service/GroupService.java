package ru.evgen.cooking_chef_project.service;

import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;

import java.util.List;

public interface GroupService {

    void addGroup(GroupRequestDto addGroupRequestDto);

    List<GroupResponsDto> getAllGroup();

    GroupResponsDto getOneGroup(long id);

}
