package com.edubridge.service;

import com.edubridge.entity.Admin;

public interface AdminService 
{
	Admin saveAdmin(Admin admin);
	Admin loginadmin(Admin admin);
	void deleteAdmin(long adminId);
}
