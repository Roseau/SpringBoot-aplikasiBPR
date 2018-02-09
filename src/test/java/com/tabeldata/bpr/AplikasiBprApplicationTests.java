package com.tabeldata.bpr;

import com.tabeldata.bpr.entity.master.Agama;
import com.tabeldata.bpr.entity.master.KotaKabupaten;
import com.tabeldata.bpr.entity.master.Pendidikan;
import com.tabeldata.bpr.entity.master.Provinsi;
import com.tabeldata.bpr.entity.master.RoleSecurity;
import com.tabeldata.bpr.entity.master.UserSecurity;
import com.tabeldata.bpr.service.AgamaService;
import com.tabeldata.bpr.service.PendidikanService;
import com.tabeldata.bpr.service.UserService;
import com.tabeldata.bpr.service.WilayahService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
//import jdk.internal.util.xml.impl.Input;
import org.mockito.internal.matchers.NotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AplikasiBprApplicationTests extends TestCase {

    @Autowired
    private AgamaService agamaService;

    @Autowired
    private PendidikanService pendidikanService;
    
    @Autowired
    private WilayahService wilayahservice;
    
    @Autowired
    private UserService userservice;
    
    @Test
    public void contextLoads() {
    }

    @Test
    public void testSimpanAgama() {
//        Agama islam = new Agama(null, "Islam", "Muslim", Timestamp.valueOf(LocalDateTime.now()), "admin");
//        agamaService.save(islam);
//
//        Agama kristen = new Agama(null, "Kristen", "Kristen Protestan", Timestamp.valueOf(LocalDateTime.now()), "admin");
//        agamaService.save(kristen);
//
//        Agama agama = new Agama(null, "Test", "untz untz untz", Timestamp.valueOf(LocalDateTime.now()), "User");
//        agamaService.save(agama);

        List<Agama> daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 0);
        
        Agama temp = agamaService.findByName("Islam");
        assertNull(temp);
        
        daftarAgama = agamaService.findyByNameAndDescription("Islam", "Kristen Protestan");
        assertEquals(daftarAgama.size(), 0);
        
//        agamaService.updateById(temp.getId(), "Islam", "Muslim");
//        temp = agamaService.findById(temp.getId());
//        assertEquals(temp.getNama(), "Islam");
//        assertEquals(temp.getDeskripsi(), "Muslim");
        
//        //kalo mau insert, ini dikomen terlebih dahulu. karena setiap run bakal di delete
//        agamaService.delete(daftarAgama);
//        daftarAgama = agamaService.findAll();
//        assertEquals(daftarAgama.size(), 0);

    }

    @Test
    public void testPendidikan(){
        List<Pendidikan> daftarPendidikan = pendidikanService.findAll();
        assertEquals(daftarPendidikan.size(), 3);
    }
    
    @Test
    public void testKotaProvinsi(){
        List<Provinsi> daftarWilayah = this.wilayahservice.findAllProvinsi();
        assertEquals(2, daftarWilayah.size());
        
        Provinsi jawaBarat = this.wilayahservice.findProvById("001");
        assertEquals(2, jawaBarat.getListKotaKab().size());
        
        List<KotaKabupaten> daftarKotaKab = this.wilayahservice.findAllKotaKabupaten();
        assertEquals(3, daftarKotaKab.size());
        
        daftarKotaKab.forEach((k)->{
            System.out.println(k.toString());
        });
    }
    @Test
    public void testUser(){
        List<RoleSecurity> roles = this.userservice.getAllRoles();
        assertEquals(2, roles.size());

        List<UserSecurity> users = this.userservice.getAllUser();
        assertEquals(2, users.size());

        UserSecurity admin = this.userservice.findUserByName("admin");
        assertNotNull(admin);
        assertEquals(2, admin.getListRole().size());

        UserSecurity dimas = this.userservice.findUserByName("dimas");
        assertNotNull(dimas);
        assertEquals(1, dimas.getListRole().size());
    }
    

}
