import { Component, OnInit } from '@angular/core';
import { Traveller } from '../../module/traveller';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addtraveller',
  templateUrl: './addtraveller.component.html',
  styleUrls: ['./addtraveller.component.css']
})
export class AddtravellerComponent implements OnInit
{
  traveller = new Traveller();
  genders=["Male","Female","Other"]
  constructor(private router:Router, private activatedRoute:ActivatedRoute){}
  ngOnInit(): void {}

  customerProfile()
    {
      this.router.navigate(['/profile'])
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
      this.router.navigate(['/viewbookinglist'])
    }
    contactUs()
    {
      this.router.navigate(['/contact'])
    }
}
