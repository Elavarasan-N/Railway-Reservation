import { Component, OnInit } from '@angular/core';
import { Admin } from '../../module/admin';
import { AdminService } from 'src/app/services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  admin=new Admin();
  message="";
    constructor(private adminService:AdminService,private router:Router) { }
    ngOnInit(): void {
    }
 adminLogin()
  {
  this.adminService.adminLoginService(this.admin).subscribe(
    data =>{console.log("Login success"),
    this.router.navigate(['\adminhome'])},
    error =>{console.log("Login Failed"),console.log(error),
  
    this.message="Login Failed. Enter a valid Email and Password"}
  )
  }
  back()
  {
    this.router.navigate(['/welcomepage'])
  }
  }