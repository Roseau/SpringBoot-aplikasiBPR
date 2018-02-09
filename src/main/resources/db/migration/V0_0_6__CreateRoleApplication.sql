/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 9, 2018
 */

create schema security;

create sequence role_seq
    start 1
    increment 1;

create table security.roles(
    role_id int8 primary key not null default nextval('role_seq'),
    rolename character varying(20) not null unique,
    created_by character varying(50),
    created_date timestamp not null
);

create table security.users(
    user_id character varying(64) not null primary key,
    username character varying(150) not null unique,
    passwd character varying(255) not null,
    is_active boolean not null,
    created_by character varying(50),
    created_date timestamp not null
);

create table security.user_roles(
    user_id character varying(64) not null references security.users(user_id),
    role_id int8 not null references security.roles(role_id)
);
