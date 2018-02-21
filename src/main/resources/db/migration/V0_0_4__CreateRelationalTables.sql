/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 6, 2018
 */
create table master_provinsi(
   kode_provinsi CHARACTER VARYING(255) not null unique primary key,
   nama_provinsi CHARACTER VARYING(50) not null,
   created_date TIMESTAMP not null,
   created_by CHARACTER VARYING(20)
 );
 
 create table master_kota_kabupaten(
   kode_kota CHARACTER VARYING(255) not null UNIQUE  primary key,
   nama_kota CHARACTER VARYING(50) not null,
   created_date TIMESTAMP not null,
   created_by CHARACTER VARYING(20),
   provinsi_id CHARACTER VARYING(255) not null REFERENCES master_provinsi(kode_provinsi)
 )

create table master_kecamatan(
    id_kecamatan int4 not null primary key default nextval('kecamatan_seq'),
    nama_kecamatan character varying(255) not null unique,
    created_date timestamp not null
);
 
create table master_kelurahan(
    id_kelurahan int4 primary key not null default nextval('kelurahan_seq'),
    nama_kelurahan character varying(255) not null unique,
    kodepos character varying(255),
    created_date timestamp not null,
    id_kec int4 not null references master_kecamatan(id_kecamatan) 
);

