import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionsForDonnorComponent } from './questions-for-donnor.component';

describe('QuestionsForDonnorComponent', () => {
  let component: QuestionsForDonnorComponent;
  let fixture: ComponentFixture<QuestionsForDonnorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionsForDonnorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionsForDonnorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
