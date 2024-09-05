import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent extends BaseListCtl implements OnInit{

  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {
      date: '' // Initialize date field
    },
    searchMessage: null,
    list: [],
    pageNo: 0
  };
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.ORDER, locator, route);
  }

  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  isValidPaymentTermInput: boolean = true;
  isValidPaymentTermInputb: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';
  paymentTermErrorMessage: string = '';
  paymentTermErrorMessageb: string = '';

 
  
    
  
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
  
  }
  limitInputb(event: any, maxLength: number) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
    } else if (!/^(1|9|2|3|4|5|6|7|8)\d{0,9}$/.test(value + event.key)) {
      event.preventDefault();
      this.isValidPaymentTermInputb= false;
    }
  
    if (!this.isValidPaymentTermInputb) {
      this.paymentTermErrorMessageb = 'Please type 1-10 digit numbers only';
    } else {
      this.paymentTermErrorMessageb = '';
    }
  
  }



}

