import { TestBed } from '@angular/core/testing';

import { PikachuResolver } from './pikachu.resolver';

describe('PikachuResolver', () => {
  let resolver: PikachuResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(PikachuResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
