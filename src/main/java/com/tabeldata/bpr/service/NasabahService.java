/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.Nasabah;
import com.tabeldata.bpr.entity.master.NasabahBadanUsaha;
import com.tabeldata.bpr.entity.master.NasabahPerorangan;
import com.tabeldata.bpr.repository.NasabahBadanUsahaRepo;
import com.tabeldata.bpr.repository.NasabahPeroranganRepo;
import com.tabeldata.bpr.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author St0rm
 */
@Transactional(readOnly = false)
@Repository
public class NasabahService {
    @Autowired
    private NasabahRepository nasabahrepository;
    @Autowired
    private NasabahPeroranganRepo nasabahperorangan;
    @Autowired
    private NasabahBadanUsahaRepo nasabahbadanusaha;
    
    @Transactional
    public Nasabah save(Nasabah nasabah) {
        return this.nasabahrepository.save(nasabah);
    }

    @Transactional
    public NasabahPerorangan save(NasabahPerorangan nasabah) {
        return this.nasabahperorangan.save(nasabah);
    }

    @Transactional
    public NasabahBadanUsaha save(NasabahBadanUsaha nasabah) {
        return this.nasabahbadanusaha.save(nasabah);
    }

    @Transactional
    public void delete(Nasabah nasabah) {
        this.nasabahrepository.delete(nasabah);
    }

    public NasabahPerorangan findPeroranganById(String id) {
        return this.nasabahperorangan.findOne(id);
    }

    public NasabahBadanUsaha findBadanUsahaById(String id) {
        return this.nasabahbadanusaha.findOne(id);
    }
}
