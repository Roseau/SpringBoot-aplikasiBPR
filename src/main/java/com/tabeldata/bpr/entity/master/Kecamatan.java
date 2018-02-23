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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author St0rm
 */
@Data
@Entity
@Table(name = "master_kecamatan")
@ToString(exclude = "listKelurahan")
@AllArgsConstructor
@NoArgsConstructor
public class Kecamatan {
    @Id
    @SequenceGenerator(
            name = "kecamatan_wilayah_seq",
            schema = "public",
            allocationSize = 1,
            initialValue = 1,
            sequenceName = "kecamatan_seq"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kecamatan_wilayah_seq")
    @Column(name = "id_kecamatan", nullable = false, unique = true)
    private long id;
    
    @Column(name = "nama_kecamatan", nullable = false)
    private String nama;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    
    @OneToMany(mappedBy = "kecamatan")
    private List<Kelurahan> listKelurahan = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "kode_kota")
    private KotaKabupaten kotakabupaten;
}
