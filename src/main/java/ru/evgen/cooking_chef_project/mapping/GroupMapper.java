package ru.evgen.cooking_chef_project.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target="quantity", expression = "java(group.getStudents().size())")
    GroupRequestDto toDtoRequest(Group group);

    @Mapping(target="quantity", expression = "java(group.getStudents().size())")
    GroupResponsDto toDtoResponse(Group group);

    @Mapping(target="quantity", expression = "java(group.getStudents().size())")
    List<GroupResponsDto> toDtoResponsList(List<Group> groupList);


    Group toEntityRequest(GroupRequestDto groupRequestDto);


    Group toEntityResponse(GroupResponsDto groupResponsDto);


    List<Group> toEntityList(List<GroupResponsDto> groupResponsDtoList);
}
//Source объект - это источник, ОТКУДА мы берем данные, в нашем случае это User.
//
//Target объект - это результат, КУДА мы подставляем данные, в нашем случае это UserResponse.