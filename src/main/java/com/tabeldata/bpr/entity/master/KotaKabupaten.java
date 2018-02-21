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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author St0rm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_kota_kabupaten")
public class KotaKabupaten {
    
    @Id
    @GenericGenerator(name = "uuid_kotakab", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kotakab")
    @Column(name = "kode_kota", nullable = false, unique = true)
    private String id;
    
    @NotEmpty(message = "Nama Tidak Boleh Kosong!")
    @Column(name = "nama_kota", nullable = false, length = 50)
    private String nama;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    
    @Column(name = "created_by", length = 20)
    private String createdBy;
    
    //@OneToOne
    @NotNull(message = "Provinsi Belum Dipilih!")
    @ManyToOne
    @JoinColumn(name = "provinsi_id", nullable = false)
    private Provinsi provinsi;
    
    @OneToMany(mappedBy = "kotakabupaten")
    private List<Kecamatan> listKecamatan = new ArrayList<>();
}
