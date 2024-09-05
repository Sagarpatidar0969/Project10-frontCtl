import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {

    super(locator.endpoints.ORDER, locator, route);
  }
  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  isValidPaymentTermInput: boolean = true;
  isValidPaymentTermInputa: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';
  paymentTermErrorMessage: string = '';
  paymentTermErrorMessagea: string = '';

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    
    flag = flag && validator.isNotNullObject(form.product);
    flag = flag && validator.isNotNullObject(form.amount);
    flag = flag && validator.isNotNullObject(form.quantity);
    flag = flag && validator.isNotNullObject(form.date);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
   
    form.quantity = data.quantity;
    form.product = data.product;
    form.amount = data.amount;
    form.date = data.date;

  
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
      this.paymentTermErrorMessage = 'Please type 1-10 digit numbers only';
    } else {
      this.paymentTermErrorMessage = '';
    }
  
  }limitInputa(event: any, maxLength: number) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } else if (!/^(1|9|2|3|4|5|6|7|8)\d{0,9}$/.test(value + event.key)) {
      event.preventDefault(); 
      this.isValidPaymentTermInputa= false;
    }
  
    if (!this.isValidPaymentTermInputa) {
      this.paymentTermErrorMessagea = 'Please type  1-10 digit numbers only';
    } else {
      this.paymentTermErrorMessagea = '';
    }
  
  }
 



  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

}

