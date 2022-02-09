import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Book} from "../model/Book.model";
import {URL} from "../constants/app-url";
import {catchError, of, tap} from "rxjs";
import {BuyForm} from "../model/buyForm.model";

@Injectable({
  providedIn: 'root'
})
export class ShopService {
  httpOptions = {
    headers: new HttpHeaders({'accept': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  buy(buy: any) {
    return this.http.post<boolean>(`${URL.Buy}`,buy, this.httpOptions)
      .pipe(
        tap(_ => console.log(`${URL.Buy}`)),
        catchError((error) => {
          console.log("error")
          return of(error)
        })
      )
  }

}
