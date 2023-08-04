import { Component, OnInit } from '@angular/core';
import { Train } from '../../module/train';
import { TrainService } from 'src/app/services/train.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainlist',
  templateUrl: './trainlist.component.html',
  styleUrls: ['./trainlist.component.css']
})
export class TrainlistComponent implements OnInit {

  train = new Train();
  trainlist:any;
  constructor(private trainService:TrainService,private router:Router){}
  public ngOnInit(): void {
    this.getAllTrainList();
  }

  //Add Train
  public addTrain()
  {
    this.router.navigate(['/addtrain']);
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

  //update train
  public updateTrain(trainId:any)
  {
    this.router.navigate(['/updatetrain',trainId]);
  }

  //delete train
  public deleteTrain(trainId:any)
  {
    console.log(trainId);
    this.trainService.deleteTrain(trainId).subscribe(
      (data:any)=>{
        this.trainlist=data;
        alert("train details deleted successfully");
        this.router.navigate(['trainlist'])
      }
    )
  }

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