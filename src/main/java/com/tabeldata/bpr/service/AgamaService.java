package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.Agama;
import com.tabeldata.bpr.repository.AgamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AgamaService {

    @Autowired
    private AgamaRepository repo ;

    @Transactional(readOnly = false)
    public Agama save(Agama x){
        return repo.save(x);
    }

    public Agama findById(String kode){
        return repo.findOne(kode);
    }

    public List<Agama> findAll(){
        return repo.findAll();
    }

    @Transactional(readOnly = false)
    public void delete(Agama x){
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(String x){
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(List<Agama> list){
        this.repo.delete(list);
    }
    
    public Agama findByName(String param){
        return this.repo.findByNama(param);
    }
    
    public List<Agama> findyByNameAndDescription(String nama, String deskripsi){
        return this.repo.findByNamaOrDeskripsi(nama, deskripsi);
    }
    @Transactional(readOnly = false)
    public void updateById(String id, String nama, String description){
        this.repo.updateNamaDanDescription(id, nama, description);
    }
}
