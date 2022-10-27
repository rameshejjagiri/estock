import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StockPrice } from 'src/app/models/stock-price';
import { Company } from '../models/company';
import { RegistratonserviceService } from '../services/registratonservice.service';


@Component({
  selector: 'app-search-company',
  templateUrl: './search-company.component.html',
  styleUrls: ['./search-company.component.css']
})
export class SearchCompanyComponent implements OnInit {
  company: Company = new Company();
  prices: StockPrice[] = [];
  constructor(private router: ActivatedRoute, private service: RegistratonserviceService) {

  }

  ngOnInit(): void {
    const code = this.router.snapshot.params['companycode'];
    this.service.searchCompanyDetails(code).subscribe(data => {
      this.company = data;

    });
  }


}
