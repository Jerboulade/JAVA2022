import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainExerciceComponent } from './main-exercice.component';

describe('MainExerciceComponent', () => {
  let component: MainExerciceComponent;
  let fixture: ComponentFixture<MainExerciceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MainExerciceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainExerciceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
