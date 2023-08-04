import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit 
{
  constructor(private route:Router) { }

  ngOnInit(): void { }
  
  logOut()
{
  this.route.navigate(['/welcomepage'])
}

}
