/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author St0rm
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NasabahPerorangan extends Nasabah {
    @Column(name = "nomor_identitas", length = 64)
    private String nomoridentitas;
    
    @Column(name = "jenis_kelamin", length = 1)
    private String jeniskelamin;
}
