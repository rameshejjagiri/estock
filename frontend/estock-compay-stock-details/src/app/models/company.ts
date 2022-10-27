import { StockPrice } from "./stock-price";
export class Company {
    companyCode: string = '';
    companyName: string = "";
    companyCEO: string = "";
    companyTurnover: string = "";
    companyWebsite: string = "";
    stockExchange: string = "";
    stockPrice: number = 0;
    stocks: StockPrice[] = [];
}
