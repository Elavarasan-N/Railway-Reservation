import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrainService } from 'src/app/services/train.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
trainlist:any;
trainName:any;
  constructor(private route :Router,private trainService:TrainService) { }

  ngOnInit(): void {
    this.getAllTrainList();
  }
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
    this.route.navigate(['/booktrain',trainId]);
  }
  searchTrain()
  {
    console.log(this.trainName);
    this.trainService.searchTrainByName(this.trainName).subscribe(
      (data:any)=>{
        this.trainlist=data;
      }
      
    )
  }

adminLogin()
{
  this.route.navigate(['/adminlogin'])
}
customerSignUp()
{
  this.route.navigate(['/customerlogin'])
}
contactUs()
{
  this.route.navigate(['/contact'])
}
aboutUs()
{
  this.route.navigate(['/aboutus'])
}

p: number = 1;
count: number = 5;
}