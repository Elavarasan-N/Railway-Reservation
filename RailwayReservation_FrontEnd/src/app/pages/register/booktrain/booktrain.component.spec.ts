import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooktrainComponent } from './booktrain.component';

describe('BooktrainComponent', () => {
  let component: BooktrainComponent;
  let fixture: ComponentFixture<BooktrainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BooktrainComponent]
    });
    fixture = TestBed.createComponent(BooktrainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
