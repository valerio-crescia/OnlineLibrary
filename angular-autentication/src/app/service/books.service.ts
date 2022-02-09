import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Book} from "../model/Book.model";
import {URL} from "../constants/app-url";
import {catchError, Observable, of, tap} from "rxjs";
import {BookAndReviews} from "../model/BookAndReviews.model";

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  httpOptions = {
    headers: new HttpHeaders({'accept': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  books() {
    return this.http.get<Book[]>(`${URL.Books}`, this.httpOptions)
      .pipe(
        tap(_ => console.log(`${URL.Books}`)),
        catchError((error) => {
          console.log("error")
          return of(error)
        })
      )
  }

  book(id: string) {
    return this.http.get<Book>(`${URL.Book(id)}`, this.httpOptions)
      .pipe(
        tap(_ => console.log("bookService")),
        catchError((error) => {
          console.log("error")
          return of(error)
        })
      )
  }
  bookAndReviews(id: string) {
    return this.http.get<BookAndReviews>(`${URL.BookAndReviews(id)}`, this.httpOptions)
      .pipe(
        tap(_ => console.log("bookService")),
        catchError((error) => {
          console.log("error")
          return of(error)
        })
      )


  }



}
