import { Component, EventEmitter, Output } from '@angular/core';
import { DayOfWeek } from 'src/app/model/DayOfWeek';
import { ProductDetails } from '../../model/ProductDetails';

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css']
})
export class ProductGridComponent {

  products:ProductDetails[] =  [
    {
      name: 'Cheese',
      price: '$5.99',
      image: 'assets/product1.jpeg',
      deliveryDays : [DayOfWeek.MONDAY, DayOfWeek.FRIDAY],
      selected: false,
      productType: 'external',
      daysInAdvance: 3
    },
    {
      name: 'Salmon',
      price: '$15.59',
      image: 'assets/product2.jpeg',
      deliveryDays : [DayOfWeek.MONDAY , DayOfWeek.WEDNESDAY , DayOfWeek.FRIDAY],
      selected: false,
      productType: 'external',
      daysInAdvance: 1
    },
    {
      name: 'Ribeye - Beef',
      price: '$13.79',
      image: 'assets/product3.jpeg',
      deliveryDays : [DayOfWeek.WEDNESDAY , DayOfWeek.THURSDAY , DayOfWeek.FRIDAY],
      selected: false,
      productType: 'internal',
      daysInAdvance: 0
    },
    {
      name: 'Chicken',
      price: '$12.00',
      image: 'assets/product4.jpeg',
      deliveryDays : [DayOfWeek.MONDAY],
      selected: false,
      productType: 'external',
      daysInAdvance: 0
    },
    {
      name: 'Bread',
      price: '$0.99',
      image: 'assets/product5.jpeg',
      deliveryDays : [DayOfWeek.THURSDAY, DayOfWeek.FRIDAY],
      selected: false,
      productType: 'temporary',
      daysInAdvance: 2
    },
    {
      name: 'Sushi',
      price: '$13.79',
      image: 'assets/product6.jpeg',
      deliveryDays : [DayOfWeek.MONDAY, DayOfWeek.FRIDAY],
      selected: false,
      productType: 'external',
      daysInAdvance: 3
    },
    {
      name: 'Water',
      price: '$1.00',
      image: 'assets/product7.jpeg',
      deliveryDays : [DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY],
      selected: false,
      productType: 'temporary',
      daysInAdvance: 5
    },
    {
      name: 'Pepsi',
      price: '$2.99',
      image: 'assets/product8.jpeg',
      deliveryDays : [DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY],
      selected: false,
      productType: 'internal',
      daysInAdvance: 2
    }
  ];


  @Output() 
  selectedProductsEmitter = new EventEmitter<ProductDetails[]>();

  sendProducts() {
    this.selectedProductsEmitter.emit(this.products.filter(product => product.selected));
  }

}
