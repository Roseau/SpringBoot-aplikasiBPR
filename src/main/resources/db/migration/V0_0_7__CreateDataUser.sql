/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 9, 2018
 */
insert into security.roles(rolename, created_by, created_date) values
    ('Administrator', 'Migration', now()),
    ('Operator', 'Migration', now());

INSERT INTO security.users (user_id, username, passwd, is_active, created_by, created_date) VALUES
  ('0001', 'admin', 'admin', TRUE, 'migration', now()),
  ('0002', 'dimas', 'dimas', FALSE, 'migration', now());

INSERT INTO security.user_roles (user_id, role_id) VALUES
  ('0001', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Administrator')),
  ('0001', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Operator')),
  ('0002', (SELECT role_id
            FROM security.roles
            WHERE rolename = 'Operator'));