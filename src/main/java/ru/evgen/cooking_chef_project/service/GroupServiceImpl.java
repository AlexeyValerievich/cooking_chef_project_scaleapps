package ru.evgen.cooking_chef_project.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.dto.for_group.GroupResponsDto;
import ru.evgen.cooking_chef_project.entity.Group;
import ru.evgen.cooking_chef_project.mapping.GroupMapper;
import ru.evgen.cooking_chef_project.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;


    @Override
    public GroupResponsDto getOneGroup(long id) {
        Group group = groupRepository.findById(id).get();
        return groupMapper.toDtoResponse(group);
    }


    @Override
    public void addGroup(GroupRequestDto addGroupRequestDto) {
        log.info("Create a new group {}", addGroupRequestDto.getNumber());

        Group group = new Group();
        group.setNumber(addGroupRequestDto.getNumber());
        groupRepository.save(group);

        log.info("Group {} saved in database", addGroupRequestDto.getNumber());
    }

    @Override
    public List<GroupResponsDto> getAllGroup() {

        List<Group> groupList = groupRepository.findAll();
        return groupMapper.toDtoResponsList(groupList);
    }

}
