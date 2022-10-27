import { Inject, Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/company';


@Injectable({
  providedIn: 'root'
})
export class RegistratonserviceService {
  private company = "/api/v1.0/market/company/";
  constructor(private httpClient: HttpClient, @Inject('BASE_API_URL') private baseUrl: string) {

  }

  getListOfCompanies(): Observable<Company[]> {
    return this.httpClient.get<Company[]>(`${this.baseUrl + this.company + 'getall'}`);
  }

  registerCompany(company: Company): Observable<Object> {
    return this.httpClient.post<Object>(`${this.baseUrl + this.company + 'register'}`, company);
  }

  searchCompanyDetails(companyCode: string): Observable<Company> {
    return this.httpClient.get<Company>(`${this.baseUrl + this.company + 'info'}/${companyCode}`);
  }
  //searchCompanyBetweendateRange()

  deleteCompanyByCOmanyCode(companyCode:String):Observable<Boolean> {
    return this.httpClient.get<Boolean>(`${this.baseUrl + this.company + 'delete'}/${companyCode}`);
  }

}
