import { Component, OnInit } from '@angular/core';
import { Train } from '../../module/train';
import { TrainService } from 'src/app/services/train.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../module/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { Account } from '../../module/account';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.css']
})
export class CustomerhomeComponent implements OnInit {
  train = new Train();
  trainlist:any;
  customerId:any;
  paymentId:any;
  accountId:any;
  customer = new Customer();
  account = new Account();

  constructor(private trainService:TrainService,private accountService:AccountService,private customerService:CustomerService,private router:Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
    this.getAllTrainList();
    this.getCustomerDetails();
    this.getAccountDetails();
    console.log(this.customerId);
    
  }

  getCustomerDetails(){
    this.customerId=this.activatedRoute.snapshot.params["customerId"]
      this.customerService.getCustomerById(this.customerId).subscribe(
        (data:any)=>{this.customer=data;
          console.log("Name = "+this.customer.firstName);
        console.log(data)}
      );
  }

  getAccountDetails()
  {
    this.accountService.getAccountByCustomerId(this.customerId).subscribe(
      (data:any)=>{
        this.customer=data;
        console.log(data);
        this.accountId = data.accountId;
      }
    )
  }

  //Get All Trains
  public getAllTrainList()
  {
    this.trainService.getAllTrain().subscribe(
      (data:any)=>{
        this.trainlist=data;
      }
    );
  } 

  public booktrain(trainId:any)
  {
    this.router.navigate(['/booktrain',trainId,this.customerId,this.accountId]);
  }

  wallet()
  {
    console.log(this.customer.customerId);
    this.router.navigate(['/wallet',this.customerId]);
  }

    customerProfile()
    {
      console.log("reaching")
      this.router.navigate(['/profile',this.customerId]);
    }
    logOut()
    {
      this.router.navigate(['/welcomepage'])
    }
    back()
    {
      this.router.navigate(['/customerlogin'])
    }
    bookingDetails ()
    {
      this.router.navigate(['/viewbookinglist',this.customerId])
    }
    contactUs()
    {
      this.router.navigate(['/contact'])
    }
    aboutUs()
    {
      this.router.navigate(['/aboutus'])
    }

    
    p: number = 1;
    count: number = 5;
}