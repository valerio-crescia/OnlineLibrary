import {environment} from "../../environments/environment.prod";


export const UseProxy = true;

export const ApiUrlAuth = UseProxy ? "AuthService1" : environment.apiUrl;
export const ApiUrlBookService = UseProxy ? "BookServiceProsumer" : environment.apiUrl;
export const ApiUrlShopProsumer = UseProxy ? "BookShopProsumer" : environment.apiUrl;
export const URL = {

  Login: ApiUrlAuth + "/rest/login",
  Books: ApiUrlBookService + "/rest/books",
  Buy: ApiUrlShopProsumer+ "/rest/buy",
  Book: (id : string) => ApiUrlBookService + "/rest/books/"+ id.toString(),
  BookAndReviews: (id : string) => ApiUrlBookService + "/rest/books/reviews/" + id.toString(),



}
