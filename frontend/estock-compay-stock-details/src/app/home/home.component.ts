import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CompanyDaterangeSearchResultsComponent } from '../company-daterange-search-results/company-daterange-search-results.component';
import { Company } from '../models/company';
import { RegistratonserviceService } from '../services/registratonservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @ViewChild(CompanyDaterangeSearchResultsComponent, { static: false }) childC!: CompanyDaterangeSearchResultsComponent;
  showChild: boolean = true;
  companySearchForm!: FormGroup;
  companyCode: String = '';
  companyName: String = '';
  company: Company = new Company();
  companiesList: Company[] = [];
  constructor(private service: RegistratonserviceService, private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.companySearchForm = this.formBuilder.group({
      companyName: ['', Validators.required],
      companyCode: ['', Validators.required],
      fromDate: ['', Validators.required],
      toDate: ['', Validators.required],
    });
    this.service.getListOfCompanies().subscribe(data => {
      this.companiesList = data;
    });
  }
  get f() { return this.companySearchForm.controls; }
  onSubmit() {
    console.log(this.companySearchForm.value);
    this.childC.getStockDetails(this.companySearchForm.value);
  }
  onSelectCompanyName(event: Event) {
    this.companyCode = (event.target as HTMLInputElement).value;
    this.companiesList.find((com) => {
      if (com.companyCode == this.companyCode) {
        this.companyCode = com.companyCode;
      }
    });

  }
  onSelectCompanyCode(event: Event) {
    this.companyCode = (event.target as HTMLInputElement).value;
    this.companiesList.find((com) => {
      if (com.companyCode == this.companyCode) {
        this.companyName = com.companyName;
      }
    });

  }


}
