import { Component, OnInit } from '@angular/core';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent implements OnInit {

  customer = new Customer();
  customerlist:any;
  constructor(private customerService:CustomerService,private router:Router){}
  public ngOnInit(): void {
    this.getAllCustomerList();
  }

 /* //Add Train
  public addTrain()
  {
    this.router.navigate(['/addtrain']);
  }
  */

  //Get All customers
  public getAllCustomerList()
  {
    this.customerService.getAllCustomer().subscribe(
      (data:any)=>{
        this.customerlist=data;
      }
    );
  }

  //update customer
  public updateCustomer(customerId:any)
  {
    this.router.navigate(['/updatecustomer',customerId]);
  }

  //delete customer
 /* public deleteCustomer(customerId:any)
  {
    console.log(customerId);
    this.customerService.deleteCustomer(customerId).subscribe(
      (data:any)=>{
        this.customerlist=data;
        alert("Customer details deleted successfully");
        this.router.navigate(['customerlist'])
      }
    )
  }*/

  logOut()
{
  this.router.navigate(['/welcomepage'])
}

aboutUs()
{
  this.router.navigate(['/aboutus'])
}
p: number = 1;
count: number = 5;
}
