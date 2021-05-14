import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentDashboardLayoutComponent } from './component-dashboard-layout.component';

describe('ComponentDashboardLayoutComponent', () => {
  let component: ComponentDashboardLayoutComponent;
  let fixture: ComponentFixture<ComponentDashboardLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentDashboardLayoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentDashboardLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
