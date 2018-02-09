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
import javax.persistence.JoinTable;
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
@Entity
@Table(name = "users", schema="security")
@Data
@ToString(exclude = "listRole")
@AllArgsConstructor
@NoArgsConstructor
public class UserSecurity {
    @Id
    @GenericGenerator(name = "userid_uuid", strategy = "uuid2")
    @GeneratedValue(generator = "userid_uuid")
    @Column(name = "user_id",nullable = false, unique = true, length = 64)
    private String id;
    
    @Column(name = "username",nullable = false, unique = true, length = 150)
    private String name;
    
    @Column(name = "passwd", nullable = false)
    private String password;
    
    @Column(name = "is_active", nullable = false)
    private boolean active;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_date", nullable = false)
    private Timestamp createDate;
    
    @OneToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false),
            schema = "security"
    )
    private List<RoleSecurity> listRole = new ArrayList<>();
}
