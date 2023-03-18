import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './components/cart/cart.component';
import { MatTableModule } from '@angular/material/table';
import { ProductGridComponent } from './components/product-grid/product-grid.component';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ShopContainerComponent } from './components/shop-container/shop-container.component';



@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    ProductGridComponent,
    ShopContainerComponent, 
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatGridListModule,
    MatCardModule,
    MatCheckboxModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
