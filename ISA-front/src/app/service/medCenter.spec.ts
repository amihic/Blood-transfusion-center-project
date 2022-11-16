import { TestBed } from '@angular/core/testing';
import { MedCenterService } from './medCenter.service';


describe('MedCenterService', () => {
  let service: MedCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
