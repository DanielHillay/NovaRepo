package com.spearhead.nova.service;

import com.spearhead.nova.model.AdminUser;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.repository.AdminRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepo;

    public ResponseEntity<StandardResponse> createAdmin(AdminUser adminUser) {
        try{
            AdminUser savedAdmin = adminRepo.save(adminUser);
            return StandardResponse.sendHttpResponse(true, "Admin successfully created", savedAdmin, "200");

        }catch (Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not create Admin");
        }
    }

    public ResponseEntity<StandardResponse> getAllAdmins() {

        try{
            List<AdminUser> listOfAdminUsers = adminRepo.findAll();
            return StandardResponse.sendHttpResponse(true, "Admin successfully created", listOfAdminUsers, "200");

        }catch (Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not get Admins");
        }
    }

    public ResponseEntity<StandardResponse> getAdminById(Long adminId) {
        try{
            AdminUser adminUser = adminRepo.findByUserId(adminId).get();

            if(ObjectUtils.isEmpty(adminUser)){
                throw new NotFoundException("This adminId is not connect to any Admin");
            }
            return StandardResponse.sendHttpResponse(true, "Here is your Admin user", adminUser, "200");

        }catch (Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not get Admin");
        }
    }

    public ResponseEntity<StandardResponse> deleteAdminById(Long adminId) {

        try{
            adminRepo.deleteById(adminId);
            return StandardResponse.sendHttpResponse(true, "Admin successfully deleted");

        }catch (Exception e){
            return StandardResponse.sendHttpResponse(false, "Could not delete Admin");
        }
    }
}
