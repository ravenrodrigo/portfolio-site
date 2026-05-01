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

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A class implementation of {@link ProjectService}
 * @author Raven Rodrigo
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private ProjectEntity translateWebToDb(Project project){
        ProjectEntity entity = new ProjectEntity();
        entity.setId(project.getProjectId());
        entity.setProjectName(project.getProjectName());
        entity.setProjectDescription(project.getProjectDescription());
        return entity;
    }

    private Project translateDbToWeb(ProjectEntity entity) {
        return new Project(entity.getId(), entity.getProjectName(), entity.getProjectDescription());
    }

    @Override
    public List<Project> getAllProjects() {
        // Database
        Iterable<ProjectEntity> projectEntities = this.projectRepository.findAll();

        // Web
        List<Project> projects = new ArrayList<>();
        projectEntities.forEach(projectEntity -> {
            projects.add(this.translateDbToWeb(projectEntity));
        });

        // Data
        return projects;
    }

    /**
     * Fetch a project using the project id.
     *
     * @param projectId
     * @return Project
     */
    @Override
    public Project getProjectById(Long projectId) {
        Optional<ProjectEntity> optional = this.projectRepository.findById(projectId);
        return this.translateDbToWeb(optional.get());
    }
}
