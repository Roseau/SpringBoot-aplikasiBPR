/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 19, 2018
 */
ALTER TABLE security.users
  ADD COLUMN nama_lengkap CHARACTER VARYING(25);
ALTER TABLE security.users
  ADD COLUMN biodata TEXT;

UPDATE security.users
SET nama_lengkap = 'asdlfkjdsf';

ALTER TABLE security.users
  ALTER COLUMN nama_lengkap SET NOT NULL;