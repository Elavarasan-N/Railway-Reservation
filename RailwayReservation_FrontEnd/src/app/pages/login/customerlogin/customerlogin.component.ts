import { Component } from '@angular/core';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent 
{
  customer=new Customer();
message="";
customerId:number = 0;
  constructor(private loginService:CustomerService,private router:Router) { }

  ngOnInit(): void {

  }
customerLogin()
{
this.loginService.loginCustomer(this.customer).subscribe(
  (data:any) =>{console.log("Login success"),
  this.customerId = data.customerId;
  this.router.navigate(['\customerhome',this.customerId])},
  error =>{console.log("Login Failed"),console.log(error),
  this.message="login failed.enter valid email and password"}
)
}
back()
{
  this.router.navigate(['/welcomepage']);
}
aboutUs()
{
  this.router.navigate(['/aboutus'])
}
}
