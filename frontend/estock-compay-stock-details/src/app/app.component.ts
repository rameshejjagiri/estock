import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Company } from './models/company';
import { RegistratonserviceService } from './services/registratonservice.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'stock-details-project';
  @Output() companycode:string='';
  
}
