package com.edubridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.entity.Admin;
import com.edubridge.service.AdminService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminservice;

	public AdminController(AdminService adminservice) 
	{
		super();
		this.adminservice = adminservice;
	}
	
	//save admin details
	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmin(@Validated @RequestBody  Admin admin)
	{
	System.out.println("admin register "+admin);
		return new ResponseEntity<Admin>(adminservice.saveAdmin(admin),HttpStatus.CREATED);
	}
	
	//admin login
	@PostMapping("/login")
	public  ResponseEntity<Admin> loginAdmin( @RequestBody Admin admin)
	{
	return new ResponseEntity<Admin>(adminservice.loginadmin(admin),HttpStatus.OK);	
	}
	
	//delete admin
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Boolean> deleteAdmin(@PathVariable long adminId)
	{
		adminservice.deleteAdmin(adminId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
	
}
