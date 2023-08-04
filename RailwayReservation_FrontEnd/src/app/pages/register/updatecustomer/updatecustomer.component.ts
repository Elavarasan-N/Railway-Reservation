import { Component, OnInit } from '@angular/core';
import { Customer } from '../../module/customer';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-updatecustomer',
  templateUrl: './updatecustomer.component.html',
  styleUrls: ['./updatecustomer.component.css']
})
export class UpdatecustomerComponent implements OnInit{
  customerId:any;
  customer = new Customer();
constructor(private activatedRouter:ActivatedRoute, private customerService:CustomerService,private route:Router){

}
ngOnInit(): void {
 this.customerId=this.activatedRouter.snapshot.params['customerId'];
this.customerService.getCustomerById(this.customerId).subscribe(
 (data:any)=>{
   this.customer=data;
 }
)
}
genders=["Male","Female","Other"];
// 
public onSubmit(){
 this.customerService.updateCustomer(this.customerId,this.customer).subscribe(
   (data:any)=>{
     alert("Customer details updated successfully");
     this.route.navigate(['customerlist']);
   }
 )
}
aboutUs()
{
  this.route.navigate(['/aboutus'])
}
}
