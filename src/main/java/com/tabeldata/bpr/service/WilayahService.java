/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.Kecamatan;
import com.tabeldata.bpr.entity.master.Kelurahan;
import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.entity.master.Provinsi;
import com.tabeldata.bpr.repository.KecamatanRepository;
import com.tabeldata.bpr.repository.KelurahanRepository;
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
    @Autowired
    private KecamatanRepository kecamatanrepo;
    @Autowired
    private KelurahanRepository kelurahanrepo;
    
    public List<Provinsi> findAllProvinsi(){
        return this.provrepo.findAll();
    }
    
    public List<KotaKabupaten> findAllKotaKabupaten(){
        return this.kokabrepo.findAll();
    }
    
    public Provinsi findProvById(String id){
        return this.provrepo.findById(id);
    }
    
    @Transactional
    public void saveProvinsi(Provinsi prov){
        this.provrepo.save(prov);
    }
    
    @Transactional
    public void deleteProvinsi(String id){
        this.provrepo.delete(id);
    }
    
    @Transactional
    public void saveKota(KotaKabupaten kota){
        this.kokabrepo.save(kota);
    }
    @Transactional
    public void deleteKota(KotaKabupaten kota){
        this.kokabrepo.delete(kota);
    }
    @Transactional
    public void deleteKotaById(String id){
        this.kokabrepo.delete(id);
    }
    @Transactional
    public KotaKabupaten findKotaById(String id){
        return this.kokabrepo.findOne(id);
    }
    
    public List<Kecamatan> getAllKecamatan(){
        return this.kecamatanrepo.findAll();
    }
    @Transactional
    public Kecamatan getKecamatanById(long kode){
        return this.kecamatanrepo.findOne(kode);
    }
    
    public List<Kelurahan> getAllKelurahan(){
        return this.kelurahanrepo.findAll();
    }
    
    public Kecamatan getKecamatanByName(String nama){
        return this.kecamatanrepo.findByNama(nama);
    }
    
    public Kelurahan getKelurahanByName(String nama){
        return this.kelurahanrepo.findByNama(nama);
    }
    public Kelurahan getKelurahanByKodepos(String kode){
        return this.kelurahanrepo.findByKodepos(kode);
    }
    @Transactional
    public void deleteKelurahan(Kelurahan kel){
        this.kelurahanrepo.delete(kel);
    }
    @Transactional
    public void saveKecamatan(Kecamatan k){
        this.kecamatanrepo.save(k);
    }
    @Transactional
    public void deleteKecamatan(long id){
        this.kecamatanrepo.delete(id);
    }
    @Transactional
    public void saveKelurahan(Kelurahan kh){
        this.kelurahanrepo.save(kh);
    }
}
