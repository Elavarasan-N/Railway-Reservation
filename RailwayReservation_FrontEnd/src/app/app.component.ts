import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'RailwayReservation_Final_Project';
  p:number = 1;
  count: number = 5;
  constructor(){
    console.log('Application loaded. Initializing data.');
  }
}
