package ru.evgen.cooking_chef_project.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T11:21:03+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupRequestDto toDtoRequest(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupRequestDto groupRequestDto = new GroupRequestDto();

        if ( group.getId() != null ) {
            groupRequestDto.setId( group.getId() );
        }
        groupRequestDto.setNumber( group.getNumber() );

        groupRequestDto.setQuantity( group.getStudents().size() );

        return groupRequestDto;
    }

    @Override
    public GroupResponsDto toDtoResponse(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupResponsDto groupResponsDto = new GroupResponsDto();

        if ( group.getId() != null ) {
            groupResponsDto.setId( group.getId() );
        }
        groupResponsDto.setNumber( group.getNumber() );

        groupResponsDto.setQuantity( group.getStudents().size() );

        return groupResponsDto;
    }

    @Override
    public List<GroupResponsDto> toDtoResponsList(List<Group> groupList) {
        if ( groupList == null ) {
            return null;
        }

        List<GroupResponsDto> list = new ArrayList<GroupResponsDto>( groupList.size() );
        for ( Group group : groupList ) {
            list.add( toDtoResponse( group ) );
        }

        return list;
    }

    @Override
    public Group toEntityRequest(GroupRequestDto groupRequestDto) {
        if ( groupRequestDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupRequestDto.getId() );
        group.setNumber( groupRequestDto.getNumber() );

        return group;
    }

    @Override
    public Group toEntityResponse(GroupResponsDto groupResponsDto) {
        if ( groupResponsDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupResponsDto.getId() );
        group.setNumber( groupResponsDto.getNumber() );

        return group;
    }

    @Override
    public List<Group> toEntityList(List<GroupResponsDto> groupResponsDtoList) {
        if ( groupResponsDtoList == null ) {
            return null;
        }

        List<Group> list = new ArrayList<Group>( groupResponsDtoList.size() );
        for ( GroupResponsDto groupResponsDto : groupResponsDtoList ) {
            list.add( toEntityResponse( groupResponsDto ) );
        }

        return list;
    }
}
