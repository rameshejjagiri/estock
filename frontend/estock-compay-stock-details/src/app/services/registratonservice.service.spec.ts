import { TestBed } from '@angular/core/testing';

import { RegistratonserviceService } from './registratonservice.service';

describe('RegistratonserviceService', () => {
  let service: RegistratonserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistratonserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
