/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.entity.master.Provinsi;
import com.tabeldata.bpr.repository.KotaKabupatenRepository;
import com.tabeldata.bpr.repository.ProvinsiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author St0rm
 */
@Service
@Transactional(readOnly = true)
public class WilayahService {
    @Autowired
    private KotaKabupatenRepository kokabrepo;
    @Autowired
    private ProvinsiRepository provrepo;
    
    public List<Provinsi> findAllProvinsi(){
        return this.provrepo.findAll();
    }
    
    public List<KotaKabupaten> findAllKotaKabupaten(){
        return this.kokabrepo.findAll();
    }
    
    public Provinsi findProvById(String id){
        return this.provrepo.findById(id);
    }
}
