/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.entity.master;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author St0rm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_provinsi")
@ToString(exclude = "listKotaKab")
public class Provinsi {
    @Id
    @GenericGenerator(name = "uuid_provinsi", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_provinsi")
    @Column(name = "kode_provinsi", nullable = false, unique = true)
    private String id;
    
    @Column(name = "nama_provinsi", nullable = false, length = 50)
    private String nama;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    
    @Column(name = "created_by", length = 20)
    private String createdBy;
    
    @OneToMany(mappedBy = "provinsi")
    private List<KotaKabupaten> listKotaKab = new ArrayList<>();
}
