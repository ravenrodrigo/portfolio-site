/*
 * Copyright 2026-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ravenrodrigo.portfolio_api.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * A test for {@link ProjectController}
 * @author Raven Rodrigo
 */
@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
public class ProjectDTOControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProjectService projectServiceMock;

    @Test
    @DisplayName("It should get all projects then return status 200.")
    void shouldGetAllProjectsThenReturnStatusIsSuccessful() throws Exception {
        // Given
        ProjectDTO firstProjectDTO = new ProjectDTO(1L, "First ProjectDTO", "This is first project.");
        ProjectDTO secondProjectDTO = new ProjectDTO(2L, "Second ProjectDTO", "This is second project");
        ProjectDTO thirdProjectDTO = new ProjectDTO(3L, "Third ProjectDTO", "This is third project");
        List<ProjectDTO> projectDTOS = List.of(firstProjectDTO, secondProjectDTO, thirdProjectDTO);

        // When
        when(projectServiceMock.getAllProjects()).thenReturn(projectDTOS);

        // Then
        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("It should return a project using id.")
    void shouldGetProjectById() throws Exception {
        // Given
        ProjectDTO firstProjectDTO = new ProjectDTO(1L, "First ProjectDTO", "This is first project.");

        // When
        when(projectServiceMock.getProjectById(firstProjectDTO.projectId())).thenReturn(firstProjectDTO);

        // Then
        mockMvc.perform(get("/api/{projectId}"))
                .andExpect(status().isOk());
    }
}
