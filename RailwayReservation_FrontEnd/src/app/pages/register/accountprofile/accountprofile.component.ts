import { Component, OnInit } from '@angular/core';
import { Account } from '../../module/account';
import { AccountService } from 'src/app/services/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../module/customer';

@Component({
  selector: 'app-accountprofile',
  templateUrl: './accountprofile.component.html',
  styleUrls: ['./accountprofile.component.css']
})
export class AccountprofileComponent implements OnInit {
  customer:Customer = new Customer();
  account:Account=new Account();
  accountId:any;
  customerId:any;
  constructor(private accountService:AccountService,private activatedRoute:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.accountId = this.activatedRoute.snapshot.params['accountId'];
    this.getAccountDetails();
  }
  getAccountDetails(){
    this.accountId=this.activatedRoute.snapshot.params["accountId"]
      this.accountService.getAccountById(this.accountId).subscribe(
        (data:any)=>{this.account=data,
        console.log(data)}
    )
        }
        saveProfile(accountId:number,account:Account)
        {
          this.accountService.updateAccount(accountId,account).subscribe(
            data=>{console.log(data),
            alert("Profile Updated Successfully");},
            error=>console.log(error)
          )
        }
        backToCustomerHomePlace(customerId:number)
        {
        this.route.navigate(['/customerhome',this.customerId])
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
