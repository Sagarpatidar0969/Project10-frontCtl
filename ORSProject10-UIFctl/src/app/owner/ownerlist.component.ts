import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ownerlist',
  templateUrl: './ownerlist.component.html',
  styleUrls: ['./ownerlist.component.css']
})
export class OwnerlistComponent extends BaseListCtl implements OnInit{

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
    super(locator.endpoints.OWNER, locator, route);
  }

  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  isValidPaymentTermInput: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';
  paymentTermErrorMessage: string = '';

 
  
    
  
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
}

