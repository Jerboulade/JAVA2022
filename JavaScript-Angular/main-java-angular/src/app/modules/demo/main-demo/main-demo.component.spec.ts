import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainDemoComponent } from './main-demo.component';

describe('MainDemoComponent', () => {
  let component: MainDemoComponent;
  let fixture: ComponentFixture<MainDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainDemoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
