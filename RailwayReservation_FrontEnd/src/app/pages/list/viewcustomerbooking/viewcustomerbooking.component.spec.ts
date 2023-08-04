import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcustomerbookingComponent } from './viewcustomerbooking.component';

describe('ViewcustomerbookingComponent', () => {
  let component: ViewcustomerbookingComponent;
  let fixture: ComponentFixture<ViewcustomerbookingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewcustomerbookingComponent]
    });
    fixture = TestBed.createComponent(ViewcustomerbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
