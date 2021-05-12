import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentSmartTableComponent } from './component-smart-table.component';

describe('ComponentSmartTableComponent', () => {
  let component: ComponentSmartTableComponent;
  let fixture: ComponentFixture<ComponentSmartTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComponentSmartTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentSmartTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
