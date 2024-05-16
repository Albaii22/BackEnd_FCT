package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fct.BackEnd.entities.Admin;
import com.fct.BackEnd.repository.AdminRepository;
import com.fct.BackEnd.services.AdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceIMP implements AdminService {

    // private static final Logger logger = LoggerFactory.getLogger(AdminServiceIMP.class);

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        // logger.info("Fetching all admins");
        List<Admin> admins = adminRepository.findAll();
        // logger.debug("Found {} admins", admins.size());
        return admins;
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        // logger.info("Fetching admin with id {}", id);
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            // logger.debug("Found admin: {}", admin.get());
        } else {
            // logger.warn("No admin found with id {}", id);
        }
        return admin;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        // logger.info("Creating new admin");
        Admin savedAdmin = adminRepository.save(admin);
        // logger.debug("Created admin: {}", savedAdmin);
        return savedAdmin;
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        // logger.info("Updating admin with id {}", id);
        admin.setId(id);
        Admin updatedAdmin = adminRepository.save(admin);
        // logger.debug("Updated admin: {}", updatedAdmin);
        return updatedAdmin;
    }

    @Override
    public void deleteAdmin(Long id) {
        // logger.info("Deleting admin with id {}", id);
        adminRepository.deleteById(id);
        // logger.debug("Deleted admin with id {}", id);
    }
}
