import { DayOfWeek } from "./DayOfWeek";

export interface Product {
    productId: string;
    name: string;
    deliveryDays: DayOfWeek[];
    productType: string;
    daysInAdvance: number;
  }