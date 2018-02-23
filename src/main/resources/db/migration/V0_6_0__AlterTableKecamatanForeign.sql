/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  St0rm
 * Created: Feb 22, 2018
 */
alter table master_kecamatan
add column kode_kota character varying(255) references master_kota_kabupaten(kode_kota)
