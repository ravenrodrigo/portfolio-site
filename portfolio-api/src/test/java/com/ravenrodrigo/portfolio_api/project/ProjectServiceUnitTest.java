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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * A unit test class for Project Service.
 *
 * @author Raven Rodrigo
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProjectServiceUnitTest {

    @InjectMocks
    ProjectServiceImpl projectServiceImplMock;

    @Mock
    ProjectRepository projectRepositoryMock;

    private final List<ProjectEntity> projects = Arrays.asList(
            new ProjectEntity("First Project", "This is the 1st project."),
            new ProjectEntity("Second Project", "This is the 2nd project."),
            new ProjectEntity("Third Project", "This is the 3rd project."),
            new ProjectEntity("Fourth Project", "This is the 4th project."),
            new ProjectEntity("Fifth Project", "This is the 5th project."),
            new ProjectEntity("Sixth Project", "This is the 6th project."),
            new ProjectEntity("Seventh Project", "This is the 7th project."),
            new ProjectEntity("Eight Project", "This is the 8th project.")
    );
    
    @Test
    @DisplayName("It should return all projects.")
    void shouldDisplayAllProjects() {
        // Arrange
        List<ProjectEntity> expectedEntities = Arrays.asList(
                new ProjectEntity(), new ProjectEntity()
        );

        // Act
        when(projectRepositoryMock.findAll()).thenReturn(expectedEntities);
        Iterable<ProjectEntity> actualEntities = projectRepositoryMock.findAll();

        // Assert
        assertNotNull(actualEntities);
        assertEquals(2, ((Collection<?>) actualEntities).size());
    }

    @Test
    @DisplayName("It should return a project by id.")
    void shouldFindProjectById() {
        // Arrange
        ProjectEntity projectToGet = new ProjectEntity();
        projectToGet.setId(1L);
        projectToGet.setProjectName("Project One");
        projectToGet.setProjectDescription("This is the project one.");
        projectRepositoryMock.save(projectToGet);

        // When
        when(projectRepositoryMock.findById(projectToGet.getId())).thenReturn(Optional.of(projectToGet));

        // Verify
        Project firstProject = projectServiceImplMock.getProjectById(projectToGet.getId());
        assertEquals(1, firstProject.getProjectId());
        verify(projectRepositoryMock, times(1)).findById(projectToGet.getId());
    }
}
