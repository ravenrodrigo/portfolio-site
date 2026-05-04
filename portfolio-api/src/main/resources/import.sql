CREATE TABLE IF NOT EXISTS
    tbl_projects (
        project_id integer primary key generated always as identity,
        project_name text,
        project_description text
);

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO One', 'This is the 1st projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Two', 'This is the 2nd projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Three', 'This is the 3rd projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Four', 'This is the 4th projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Five', 'This is the 5th projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Six', 'This is the 6th projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Seven', 'This is the 7th projectDTO.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('ProjectDTO Eight', 'This is the 8th projectDTO.');