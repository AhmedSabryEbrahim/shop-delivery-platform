import { Product } from "./Product";

export interface Cart {
    postalCode: string;
    products: Product[];
}