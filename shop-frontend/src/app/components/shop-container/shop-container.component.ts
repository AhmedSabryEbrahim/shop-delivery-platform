import { Component } from '@angular/core';
import { Cart } from 'src/app/model/Cart';
import { DayOfWeek } from 'src/app/model/DayOfWeek';
import { DeliveryDate } from 'src/app/model/DeliveryDate';
import { ProductDetails } from 'src/app/model/ProductDetails';
import { Product } from 'src/app/model/Product';
import { CartService } from '../../service/cart.service';

@Component({
  selector: 'app-shop-container',
  templateUrl: './shop-container.component.html',
  styleUrls: ['./shop-container.component.css']
})
export class ShopContainerComponent {
  cart: Cart = {
    postalCode: '12345',
    products: [
      {
        productId: 'p1',
        name: 'Product 1',
        deliveryDays: [DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY],
        productType: 'external',
        daysInAdvance: 3
      },
      {
        productId: 'p2',
        name: 'Product 2',
        deliveryDays: [DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY],
        productType: 'temporary',
        daysInAdvance: 0
      },
      {
        productId: 'p3',
        name: 'Product 3',
        deliveryDays: [DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY],
        productType: 'internal',
        daysInAdvance: 1
      }
    ]
  };

  deliveryDates: DeliveryDate[] = [];

  constructor(private cartService: CartService) { }

  sendCart(selectedProducts: ProductDetails[]): void {
  
    const products: Product[] = selectedProducts.map(this.mapProductDetailsToProduct);
    this.cart = {
      postalCode: '12345',
      products: products
    };
    console.log(this.cart);
    this.cartService.checkAvailableDeliveryDate(this.cart).subscribe(
      data => {
        this.deliveryDates = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }


  mapProductDetailsToProduct(productDetails: ProductDetails): Product {
    const product: Product = {
      productId: '',
      name: productDetails.name,
      deliveryDays: productDetails.deliveryDays,
      productType: productDetails.productType,
      daysInAdvance: productDetails.daysInAdvance
    };
    return product;
  }

}
