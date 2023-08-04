import { Component } from '@angular/core';
import { TrainService } from 'src/app/services/train.service';
import { Train } from '../../module/train';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addtrain',
  templateUrl: './addtrain.component.html',
  styleUrls: ['./addtrain.component.css']
})
export class AddtrainComponent 
{
    constructor(private trainService : TrainService,private router:Router){}
    train=new Train();
  
    public saveTrain(){
  console.log(this.train);
  this.trainService.addTrain(this.train).subscribe(
  (data:any)=>{
    alert("added successfuly");
    this.router.navigate(['trainlist'])
  }
  );
    }
    aboutUs()
{
  this.router.navigate(['/aboutus'])
}
}
