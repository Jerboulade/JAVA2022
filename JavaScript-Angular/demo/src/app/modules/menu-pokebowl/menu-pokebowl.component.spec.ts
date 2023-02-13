import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuPokebowlComponent } from './menu-pokebowl.component';

describe('MenuPokebowlComponent', () => {
  let component: MenuPokebowlComponent;
  let fixture: ComponentFixture<MenuPokebowlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuPokebowlComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuPokebowlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
