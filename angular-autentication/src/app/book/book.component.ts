import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Observable} from "rxjs";
import {Book} from "../model/Book.model";
import {BooksService} from "../service/books.service";
import {BookAndReviews} from "../model/BookAndReviews.model";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  bookAndReviews$: Observable<BookAndReviews> | undefined;
  constructor(private service: BooksService,
              private route: ActivatedRoute,
              private router: Router,
              ) {

  }
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.bookAndReviews$ = this.service.bookAndReviews(id);
      this.bookAndReviews$.subscribe();
    }

  }
  gotoBuyForm(book: Book) {
    const id = book ? book.id : null;
    this.router.navigate([ `buy/${id}`]);
  }
}
