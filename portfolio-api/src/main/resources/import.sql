CREATE TABLE IF NOT EXISTS
    tbl_projects (
        project_id integer primary key generated always as identity,
        project_name text,
        project_description text
);

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project One', 'This is the 1st project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Two', 'This is the 2nd project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Three', 'This is the 3rd project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Four', 'This is the 4th project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Five', 'This is the 5th project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Six', 'This is the 6th project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Seven', 'This is the 7th project.');

INSERT INTO tbl_projects (project_name, project_description)
VALUES ('Project Eight', 'This is the 8th project.');