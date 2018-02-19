/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.bpr.service;

import com.tabeldata.bpr.entity.master.RoleSecurity;
import com.tabeldata.bpr.entity.master.UserSecurity;
import com.tabeldata.bpr.repository.RoleRepository;
import com.tabeldata.bpr.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author St0rm
 */
@Repository
@Transactional(readOnly = false)
public class UserService {
    @Autowired
    private UserRepository userepository;
    @Autowired
    private RoleRepository rolerepository;
    
    public List<RoleSecurity> getAllRoles(){
        return this.rolerepository.findAll();
    }
    
    public List<UserSecurity> getAllUser(){
        return this.userepository.findAll();
    }
    
    public UserSecurity findUserByName(String nama){
        return this.userepository.findByName(nama);
    }
    public void Save(UserSecurity user){
        userepository.save(user);
    }
    public void Delete(String userid){
        userepository.delete(userid);
    }
}
