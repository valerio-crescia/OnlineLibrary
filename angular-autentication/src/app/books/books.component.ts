import {Component, OnDestroy, OnInit} from '@angular/core';
import {Book} from "../model/Book.model";
import {Observable} from "rxjs";
import {BooksService} from "../service/books.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit, OnDestroy {
  books$: Observable<Book[]>;
  books: Book[] = [];

  constructor(
    private service: BooksService,
    private router: Router,
    ) {
    this.books$ = service.books()
    this.books$.subscribe(books => {
      this.books = books;
    })
  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
  }

  gotoBook(book: Book) {
    const id = book ? book.id : null;
    this.router.navigate([ `book/${id}`]);
  }

}
