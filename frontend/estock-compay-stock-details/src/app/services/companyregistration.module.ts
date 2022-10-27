import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationComponent } from '../registration/registration.component';
import { ListOfCompaniesComponent } from '../list-of-companies/list-of-companies.component'; 
import { FormsModule } from '@angular/forms';
import { SearchCompanyComponent } from '../search-company/search-company.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    RegistrationComponent,
    ListOfCompaniesComponent,
    SearchCompanyComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CompanyregistrationModule { 

}
