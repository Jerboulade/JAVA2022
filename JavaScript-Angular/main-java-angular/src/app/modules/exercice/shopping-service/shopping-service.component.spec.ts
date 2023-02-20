import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingServiceComponent } from './shopping-service.component';

describe('ShoppingServiceComponent', () => {
  let component: ShoppingServiceComponent;
  let fixture: ComponentFixture<ShoppingServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoppingServiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoppingServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
