import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddtravellerComponent } from './addtraveller.component';

describe('AddtravellerComponent', () => {
  let component: AddtravellerComponent;
  let fixture: ComponentFixture<AddtravellerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddtravellerComponent]
    });
    fixture = TestBed.createComponent(AddtravellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
