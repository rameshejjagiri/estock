import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StockPrice } from 'src/app/models/stock-price';
import { Company } from '../models/company';
import { RegistratonserviceService } from '../services/registratonservice.service';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-list-of-companies',
  templateUrl: './list-of-companies.component.html',
  styleUrls: ['./list-of-companies.component.css']
})
export class ListOfCompaniesComponent implements OnInit {

  company: Company[] = [];
  prices: StockPrice[] = [];
  stock: StockPrice = new StockPrice();
  ngOnInit(): void {
    this.getCompaiesList();

  }
  constructor(private companyService: RegistratonserviceService, private stockService: StockService, private router: Router) {

  }

  private getCompaiesList() {
    this.companyService.getListOfCompanies().subscribe(data => {
      console.log(data);
      this.company = data;
      for (let test of data) {
        for (let stocks of test.stocks) {
          this.prices.push(stocks);
        }
      }

    })
  }
  delete(companyCode: String) {

    this.companyService.deleteCompanyByCOmanyCode(companyCode).subscribe(data => {
    })
    this.getCompaiesList();

  }
  addStock(companyCode: String) {
    alert(companyCode);

    this.router.navigate(['/add-stock', companyCode]);

  }




}
