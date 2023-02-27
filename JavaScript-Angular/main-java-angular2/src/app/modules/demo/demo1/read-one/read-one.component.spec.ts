import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadOneComponent } from './read-one.component';

describe('ReadOneComponent', () => {
  let component: ReadOneComponent;
  let fixture: ComponentFixture<ReadOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReadOneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReadOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
