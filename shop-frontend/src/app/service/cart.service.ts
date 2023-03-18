import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/Cart';
import { DeliveryDate } from '../model/DeliveryDate';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }

  checkAvailableDeliveryDate(cart: Cart): Observable<DeliveryDate[]> {
    return this.http.post<any>('http://localhost:8080/carts', cart);
  }
  
}
