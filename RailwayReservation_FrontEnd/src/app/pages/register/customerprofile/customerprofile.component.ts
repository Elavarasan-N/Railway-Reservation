import { Component, OnInit } from '@angular/core';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customerprofile',
  templateUrl: './customerprofile.component.html',
  styleUrls: ['./customerprofile.component.css']
})
export class CustomerprofileComponent implements OnInit {
  customer:Customer=new Customer();
  customerId:any
  constructor(private customerService:CustomerService,private activatedRoute:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
    this.getCustomerDetails();
  }
  getCustomerDetails(){
    this.customerId=this.activatedRoute.snapshot.params["customerId"]
      this.customerService.getCustomerById(this.customerId).subscribe(
        (data:any)=>{this.customer=data,
        console.log(data)}
    )
        }
        saveProfile(customerId:number,customer:Customer)
        {
          this.customerService.updateCustomer(customerId,customer).subscribe(
            data=>{console.log(data),
            alert("Profile Updated Successfully");},
            error=>console.log(error)
          )
        }
        backToCustomerHomePlace(customerId:number)
        {
        this.route.navigate(['/customerhome',customerId])
        }
        logOut()
        {
          this.route.navigate(['/welcomepage'])
        }
        home()
        {
          this.route.navigate(['/customerhome',this.customerId])
        }
        customerProfile()
        {
          this.route.navigate(['/profile',this.customerId])
        }
        genders=["Male","Female","Other"]
        contactUs()
        {
          this.route.navigate(['/contact'])
        }
        aboutUs()
{
  this.route.navigate(['/aboutus'])
}
}