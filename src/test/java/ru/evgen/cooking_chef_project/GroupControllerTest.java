package ru.evgen.cooking_chef_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.evgen.cooking_chef_project.controller.GroupController;
import ru.evgen.cooking_chef_project.dto.for_group.GroupRequestDto;
import ru.evgen.cooking_chef_project.entity.Group;
import ru.evgen.cooking_chef_project.service.GroupService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class GroupControllerTest {

    @Mock
    private GroupService groupService;

    @InjectMocks
    private GroupController groupController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(groupController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getAllGroupTest() throws Exception {
        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk());
        verify(groupService, times(1)).getAllGroup();
    }

    @Test
    void addGroupTest() throws Exception {
        GroupRequestDto group = new GroupRequestDto();
        group.setId(332l);
        group.setNumber("11-22");
        String groupJson = objectMapper.writeValueAsString(group);
        mockMvc.perform(post("/groups")
                .contentType(MediaType.APPLICATION_JSON)
                .content(groupJson))
                .andExpect(status().isCreated());

        verify(groupService, times(1)).addGroup(group);
    }

    @Test
    void getOneGroupTest() throws Exception {
        mockMvc.perform(get("/groups/{id}", 1L)).andExpect(status().isOk());
    }
}
