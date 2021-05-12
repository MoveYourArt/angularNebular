import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentSidebarFixedComponent } from './component-sidebar-fixed.component';

describe('ComponentSidebarFixedComponent', () => {
  let component: ComponentSidebarFixedComponent;
  let fixture: ComponentFixture<ComponentSidebarFixedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentSidebarFixedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentSidebarFixedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
