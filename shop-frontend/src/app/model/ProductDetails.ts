import { DayOfWeek } from "./DayOfWeek";

export interface ProductDetails {
    name: string;
    image: string;
    price: string;
    deliveryDays: DayOfWeek[];
    selected: boolean;
    productType: string;
    daysInAdvance: number;
}