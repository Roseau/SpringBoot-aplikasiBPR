/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 21, 2018
 */
create sequence kecamatan_seq
    start 1
    increment 1;

create table master_kecamatan(
    id_kecamatan int4 not null primary key default nextval('kecamatan_seq'),
    nama_kecamatan character varying(255) not null unique,
    created_date timestamp not null
);
 
create table master_kelurahan(
    kodepos character varying(255) primary key not null,
    nama_kelurahan character varying(255) not null,
    created_date timestamp not null,
    id_kec int4 not null references master_kecamatan(id_kecamatan) 
);
