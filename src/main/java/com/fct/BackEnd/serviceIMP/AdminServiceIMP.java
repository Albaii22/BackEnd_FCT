package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fct.BackEnd.entities.Admin;
import com.fct.BackEnd.repository.AdminRepository;
import com.fct.BackEnd.services.AdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceIMP implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin admin) {
        admin.set_id(id);
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}