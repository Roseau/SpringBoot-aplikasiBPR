/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.entity.master.Provinsi;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author St0rm
 */
public interface ProvinsiRepository extends CrudRepository<Provinsi, String>{
    List<Provinsi> findAll();
    
    Provinsi findById(String id);
}
