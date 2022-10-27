import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StockPrice } from '../models/stock-price';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  private stock = "/api/v/1.0/market/stock/get/";
  constructor(private httpClient: HttpClient, @Inject('BASE_API_URL') private baseUrl: string) { }

  searchCompanyBetweendate(searchForm: any): Observable<StockPrice[]> {
    return this.httpClient.get<StockPrice[]>(`${this.baseUrl + this.stock + searchForm.companyCode + '/' + searchForm.fromDate + '/' + searchForm.toDate}`);
  }
  addStockByCOmanyCode(stockPrice:StockPrice,companyCode:String):Observable<Boolean>{
    return this.httpClient.post<Boolean>(`${this.baseUrl + this.stock +'add'+stockPrice}`,stockPrice);
  }

}
