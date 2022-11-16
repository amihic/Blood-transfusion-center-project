import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedCentersComponent } from './med-centers.component';

describe('MedCentersComponent', () => {
  let component: MedCentersComponent;
  let fixture: ComponentFixture<MedCentersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedCentersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
