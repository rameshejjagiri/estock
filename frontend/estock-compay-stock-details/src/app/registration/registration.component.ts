import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Company } from '../models/company';
import { RegistratonserviceService } from '../services/registratonservice.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm!: FormGroup;
  submitted = false;
  company: Company = new Company();
  constructor(private service: RegistratonserviceService, private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      companyName: ['', Validators.required],
      companyCEO: ['', Validators.required],
      companyTurnover: ['', Validators.required],
      companyWebsite: ['', Validators.required],
      stockExchange: ['', Validators.required],
      stockPrice: ['', Validators.required]
    });
  }
  get f() { return this.registerForm.controls; }


  onSubmit() {
    console.log("test");
    // stop here if form is invalid
    console.log(this.company);
    this.service.registerCompany(this.company).subscribe(data => {
      console.log(data);
    });
    this.router.navigate(['/compaies-list']);
  }


}
