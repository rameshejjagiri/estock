import { Component, OnInit } from '@angular/core';
import { Company } from '../models/company';
import { StockPrice } from '../models/stock-price';
import { RegistratonserviceService } from '../services/registratonservice.service';
import { StockService } from '../services/stock.service';

@Component({
  selector: 'app-company-daterange-search-results',
  templateUrl: './company-daterange-search-results.component.html',
  styleUrls: ['./company-daterange-search-results.component.css']
})
export class CompanyDaterangeSearchResultsComponent implements OnInit {
  submitted = false;
  stocks: StockPrice[] = [];
  stockPrices: Array<number> = [];
  total: number = 0;
  arrayLength: number = 0;
  min: Number = 0;
  max: Number = 0;
  avg: Number = 0;

  constructor(private stockService: StockService) {

  }

  ngOnInit(): void {
  }

  getStockDetails(searchForm: any) {
    console.log('Childcomponetn is working');
    this.stockService.searchCompanyBetweendate(searchForm).subscribe(data => {
      console.log(data);
      this.stocks = data;
      this.stockPrices = this.stocks.map(function (stock) {
        return stock.stockPrice;
      });
      this.arrayLength=this.stockPrices.length;
      this.total = this.stockPrices.reduce((a, b) => a + b);
      this.max = this.stockPrices.reduce((a, b) => Math.max(a, b));
      this.min = this.stockPrices.reduce((a, b) => Math.min(a, b));
      this.avg = (this.total / this.arrayLength);


    });

  }

}
