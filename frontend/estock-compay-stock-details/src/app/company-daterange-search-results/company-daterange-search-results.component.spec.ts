import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyDaterangeSearchResultsComponent } from './company-daterange-search-results.component';

describe('CompanyDaterangeSearchResultsComponent', () => {
  let component: CompanyDaterangeSearchResultsComponent;
  let fixture: ComponentFixture<CompanyDaterangeSearchResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyDaterangeSearchResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyDaterangeSearchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
