import { Component, Input } from '@angular/core';

import { CartService } from '../../service/cart.service';
import { Cart } from '../../model/Cart';
import { DayOfWeek } from '../../model/DayOfWeek';
import { DeliveryDate } from '../../model/DeliveryDate';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  @Input()
  deliveryDates:DeliveryDate[] = [];

}
