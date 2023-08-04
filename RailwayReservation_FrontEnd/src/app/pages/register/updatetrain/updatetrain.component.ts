import { Component, OnInit } from '@angular/core';
import { Train } from '../../module/train';
import { ActivatedRoute, Router } from '@angular/router';
import { TrainService } from 'src/app/services/train.service';

@Component({
  selector: 'app-updatetrain',
  templateUrl: './updatetrain.component.html',
  styleUrls: ['./updatetrain.component.css']
})
export class UpdatetrainComponent implements OnInit{
  trainId:any;
  train = new Train();
constructor(private activatedRouter:ActivatedRoute, private trainService:TrainService,private route:Router){

}
ngOnInit(): void {
 this.trainId=this.activatedRouter.snapshot.params['trainId'];
this.trainService.getTrainById(this.trainId).subscribe(
 (data:any)=>{
   this.train=data;
 }
)
}
// 
public onSubmit(){
 this.trainService.updateTrain(this.trainId,this.train).subscribe(
   (data:any)=>{
     alert("Train details updated successfully");
     this.route.navigate(['trainlist']);
   }
 )
}
aboutUs()
{
  this.route.navigate(['/aboutus'])
}
}
