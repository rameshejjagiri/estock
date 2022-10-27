import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyregistrationModule } from './services/companyregistration.module';
import { RegistrationComponent } from './registration/registration.component';
import { ListOfCompaniesComponent } from './list-of-companies/list-of-companies.component';
import { SearchCompanyComponent } from './search-company/search-company.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { environment } from 'src/environments/environment';
import { HomeComponent } from './home/home.component';
import { CompanyDaterangeSearchResultsComponent } from './company-daterange-search-results/company-daterange-search-results.component';
import { AddStockComponent } from './add-stock/add-stock.component';
const routes: Routes = [
  { path: 'compaies-list', component: ListOfCompaniesComponent },
  { path: 'register', component: RegistrationComponent },
  { path: '', component: HomeComponent },
  { path: 'search/:companycode', component: SearchCompanyComponent },
  { path: 'add-stock/:companycode', component: AddStockComponent },

];


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CompanyDaterangeSearchResultsComponent,
    AddStockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CompanyregistrationModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    { provide: "BASE_API_URL", useValue: environment.apiUrl }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
