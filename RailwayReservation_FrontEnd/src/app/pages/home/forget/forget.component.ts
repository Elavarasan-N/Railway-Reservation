import { Component, OnInit } from '@angular/core';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent implements OnInit {
  customer=new Customer();
  status:boolean =true;false:any;
  customerId:number = 0;
  message="";
    constructor(private customerService:CustomerService,private route:Router) { }
  
    ngOnInit(): void {
      
    }
  submitEmail()
  {
    this.customerService.getCustomerByEmail(this.customer).subscribe(
      (data:any)=>{console.log(data),
        alert("Success......enter new password")
      this.customerId=data.customerId,
  this.customer=data
  this.status=true},
  
      (error:any)=>{console.log(error),
        this.message="email does not exist! enter correct email."
        this.status=false}
    )
  }
  submitPass()
  {
    this.customerService.updateCustomer(this.customerId,this.customer).subscribe(
      (data:any)=>{console.log(data),
      alert("Password Updated Successfully");
    this.route.navigate(['/customerlogin'])},
      (error:any)=>console.log(error)
    )
  }
  }