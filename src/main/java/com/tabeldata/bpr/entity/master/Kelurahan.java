/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.entity.master;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name = "master_kelurahan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kelurahan {
    @Id
    @Column(name = "kodepos", nullable = false, unique = true)
    private String kodepos;
    
    @Column(name = "nama_kelurahan", nullable = false)
    private String nama;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    
    @ManyToOne
    @JoinColumn(name = "id_kecamatan", nullable = false)
    private Kecamatan kecamatan;
}
