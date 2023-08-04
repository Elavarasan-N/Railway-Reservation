package com.edubridge.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.entity.Admin;
import com.edubridge.exception.AdminNotFoundException;
import com.edubridge.exception.TrainNotFoundException;
import com.edubridge.repository.AdminRepository;
import com.edubridge.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired 
	private AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) 
	{
		if(admin.getPassword().equals(admin.getConfirmPassword()))
		{
		return adminRepository.save(admin);
		}
		else 
		{
			return null;
		}
	}

	@Override
	public Admin loginadmin(Admin admin) 
	{
		return this.adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword()).orElseThrow(()->new AdminNotFoundException("Admin ", "Id",admin.getEmail()+"and password "+admin.getPassword() ));
	}

	@Override
	public void deleteAdmin(long adminId) 
	{
		adminRepository.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin ", "adminId", adminId));
		adminRepository.deleteById(adminId);
	}
	

}
