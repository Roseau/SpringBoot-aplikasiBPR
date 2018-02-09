/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.repository;

import com.tabeldata.bpr.entity.master.NasabahPerorangan;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author St0rm
 */
public interface NasabahPeroranganRepo extends CrudRepository<NasabahPerorangan, String> {
    
}
