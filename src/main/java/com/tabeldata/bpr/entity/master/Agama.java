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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author dimmaryanto93
 */
@Entity
@Table(name = "master_agama")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agama {
    
    @Id
    @GenericGenerator(name = "agama_id", strategy = "uuid2")
    @GeneratedValue(generator = "agama_id")
    @Column(name = "kode_agama")
    private String id;
    
    @NotNull(message = "Tidak Boleh KOSONG!")
    @NotEmpty(message = "Tidak Boleh Sting Kosong")
    @Size(min = 5, max = 50, message = "Deskipsi haus benilai antara 5 hingga 50 kaakter")
    @Column(name = "nama_agama", nullable = false, unique = true, length = 50)
    private String nama;
    
    @Column(name = "deskripsi")
    private String deskripsi;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 50)
    private String createdBy;
    
}
