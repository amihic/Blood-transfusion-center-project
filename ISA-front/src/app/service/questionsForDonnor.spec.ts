import { TestBed } from '@angular/core/testing';
import { QuestionsForDonnorService } from './questionsForDonnor.service';


describe('QuestionsForDonnorService', () => {
  let service: QuestionsForDonnorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuestionsForDonnorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
