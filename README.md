# Portfolio Site 

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## Introduction

A website that showcase the projects made by a professional.

## Swagger UI

Navigate to [<u>http://localhost:8080/swagger-ui/index.html</u>](http://localhost:8080/swagger-ui/index.html) when the server started in the development environment. Swagger by default is not enabled in another enviroments.

## Services

> <i>Please refer to the 'Swagger UI' section regarding on the details of the API specification.</i>

### Projects

| Service Name     | HTTP Method | URL       | Parameter   | Summary             |
|------------------|:-----------:| --------- | ----------- | ---------------------
| *Get All Projects* | `GET`       | `/api/`   | None        | Fetch all projects  |
| *Get Project by ID | `GET` | /api/{projectId} | projectId | Fetch a project |
