package com.spearhead.nova.resource;

/*import com.spearhead.nova.model.AdminUser;
import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminuser")
public class AdminUserController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseEntity<StandardResponse> createdAdmin(@RequestBody AdminUser adminUser){

        return adminService.createAdmin(adminUser);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAdminById(@RequestParam("adminId") Long adminId){
        return adminService.getAdminById(adminId);
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteAdminById(@RequestParam ("adminId") Long adminId){
        return adminService.deleteAdminById(adminId);
    }



}
*/