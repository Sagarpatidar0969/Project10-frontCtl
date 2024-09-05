import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {

    super(locator.endpoints.OWNER, locator, route);
  }
  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  isValidPaymentTermInput: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';
  paymentTermErrorMessage: string = '';

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.vehicleId);
    flag = flag && validator.isNotNullObject(form.insuranceAmount);
    flag = flag && validator.isNotNullObject(form.dob);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    console.log(form.quantity + " inside populateForm method");

    form.vehicleId = data.vehicleId;
    form.insuranceAmount = data.insuranceAmount;
    form.dob = data.dob;

  
  }

  limitInput(event: any, maxLength: number) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } else if (!/^(1|9|2|3|4|5|6|7|8)\d{0,9}$/.test(value + event.key)) {
      event.preventDefault(); 
      this.isValidPaymentTermInput= false;
    }
  
    if (!this.isValidPaymentTermInput) {
      this.paymentTermErrorMessage = 'Please type numbers only';
    } else {
      this.paymentTermErrorMessage = '';
    }
  
  }
  limitInputw(event: any, maxLength: Text) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } else if (!/^[a-zA-Z]*$\d{0,15}$/.test(value + event.key)) {
      event.preventDefault();
      this.isValidNameInput= false;
    }

    if (!this.isValidNameInput) {
      this.nameErrorMessage = 'Please type alphabets only';
    } else {
      this.nameErrorMessage = '';
    }


  }




  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

}

