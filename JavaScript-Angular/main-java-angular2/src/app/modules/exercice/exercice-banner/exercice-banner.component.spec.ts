import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciceBannerComponent } from './exercice-banner.component';

describe('ExerciceBannerComponent', () => {
  let component: ExerciceBannerComponent;
  let fixture: ComponentFixture<ExerciceBannerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExerciceBannerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExerciceBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
