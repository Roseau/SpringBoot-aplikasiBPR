/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 9, 2018
 */
CREATE SCHEMA nasabah;

CREATE TABLE nasabah.data_nasabah (
  tipe_nasabah    CHARACTER VARYING(50),
  nasabah_id      CHARACTER VARYING(64) NOT NULL PRIMARY KEY,
  nama_lengkap    CHARACTER VARYING(50) NOT NULL,
  nama_alamat     CHARACTER VARYING(255),
  nomor_npwp      CHARACTER VARYING(62),
  nomor_identitas CHARACTER VARYING(64),
  jenis_kelamin   CHARACTER VARYING(1)
);
