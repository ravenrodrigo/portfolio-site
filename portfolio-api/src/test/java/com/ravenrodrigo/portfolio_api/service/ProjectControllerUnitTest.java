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
package com.ravenrodrigo.portfolio_api.service;

import com.ravenrodrigo.portfolio_api.project.Project;
import com.ravenrodrigo.portfolio_api.project.ProjectController;
import com.ravenrodrigo.portfolio_api.project.ProjectServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * A test for {@link ProjectController}
 * @author Raven Rodrigo
 */
@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
public class ProjectControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ProjectServiceImpl projectServiceImplMock;

    @Test
    @DisplayName("It should get all projects then return status 200.")
    void shouldGetAllProjectsThenReturnStatusIsSuccessful() throws Exception {
        // Given
        Project firstProject = new Project(1L, "First Project", "This is first project.");
        Project secondProject = new Project(2L, "Second Project", "This is second project");
        Project thirdProject = new Project(3L, "Third Project", "This is third project");
        List<Project> projects = List.of(firstProject, secondProject, thirdProject);

        // When
        when(projectServiceImplMock.getAllProjects()).thenReturn(projects);

        // Then
        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk());
    }
}
