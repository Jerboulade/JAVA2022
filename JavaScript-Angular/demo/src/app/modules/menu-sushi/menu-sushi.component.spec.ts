import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuSushiComponent } from './menu-sushi.component';

describe('MenuSushiComponent', () => {
  let component: MenuSushiComponent;
  let fixture: ComponentFixture<MenuSushiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuSushiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuSushiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
