package com.example.userapp.controller.sync;

import com.example.model.UserRequest;
import com.example.userapp.DepartmentResponseGrpc;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Sql("/init.sql")
@Testcontainers
@AutoConfigureMockMvc
class UserControllerTest {

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:12.3");

    private static final String BASE_URL = "/api/v1/users";

    @Autowired
    private MockMvc mockMvc;

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Autowired
    private UserRepository userRepository;

    @MockBean
    private DepartmentService departmentService;


    @Test
    void createUser() throws Exception {
        UserRequest request = new UserRequest();
        request.setFirstName("Grave");
        request.setLastName("Worm");
        request.setEmail("graveworm@yandex.ru");

        int countBefore = userRepository.findAll().size();

        mockMvc.perform(post(BASE_URL + "/create")
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Grave Worm")));

        int countAfter = userRepository.findAll().size();

        Assertions.assertEquals(1, countAfter - countBefore);
    }

    @Test
    void deleteUserById() throws Exception {

        int countBefore = userRepository.findAll().size();

        mockMvc.perform(delete(BASE_URL + "/5"))
                .andExpect(status().isNoContent())
                .andExpect(mvcResult ->
                        Assertions.assertEquals(countBefore - 1, userRepository.findAll().size()));
    }

    @Test
    void findUserById() throws Exception {

        // Given
        DepartmentResponseGrpc developmentDepartment = DepartmentResponseGrpc.newBuilder().setName("Development").build();
        given(departmentService.getDepartment("643d1a48362ea1a74ec9f4a4")).willReturn(developmentDepartment);

        // Then
        mockMvc.perform(get(BASE_URL + "/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Veda Grieves")))
                .andExpect(jsonPath("$.department.name", is("Development")));
    }

    @Test
    void findAllUsers() throws Exception {
        mockMvc.perform(get(BASE_URL + "/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    void updateUser() {
    }
}