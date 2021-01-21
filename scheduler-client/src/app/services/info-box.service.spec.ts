import { TestBed } from '@angular/core/testing';

import { InfoBoxService } from './info-box.service';

describe('InfoBoxServiceService', () => {
  let service: InfoBoxService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InfoBoxService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
