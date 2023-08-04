import { Component, OnInit } from '@angular/core';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.css']
})
export class CustomerregisterComponent implements OnInit 
{
  customer=new Customer();
  message=""
    constructor(private customerService:CustomerService,private router:Router) { }
  
    ngOnInit(): void {
      this.customer.gender="Male"
    }
    customerRegister(){
      this.customerService.saveCustomer(this.customer).subscribe(
        data =>{alert("Login Succes"),
      this.router.navigate(['\customerlogin'])},
        error =>{console.log("Login Failed"),
      this.message="login failed. try again"})
      }
      genders=["Male","Female","Other"]
      back()
      {
        this.router.navigate(['/customerlogin'])
      }
  }
