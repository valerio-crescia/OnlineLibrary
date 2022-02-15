import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {BooksService} from "../service/books.service";
import {Observable} from "rxjs";
import {BookAndReviews} from "../model/BookAndReviews.model";
import {Book} from "../model/Book.model";
import {BuyForm} from "../model/buyForm.model";
import {ShopService} from "../service/shop.service";


@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  book$: Observable<Book> | undefined;


  form = this.fb.group({
    jwt: ['', Validators.required],
    bookId: [0, Validators.required],
    recipient: ['', Validators.required],
    address: ['', Validators.required],
    cardHolder: ['', Validators.required],
    cardNumber: ['', [Validators.required, Validators.min(1)]],
    cardSecretCode: ['', [Validators.required, Validators.min(1)]],
    amount: ['', [Validators.required, Validators.min(1)]],
    weight: ['', [Validators.required, Validators.min(1)]],
    userId: ['', [Validators.required, Validators.min(1)]]

  })
  jwt: string | undefined;
  userId: number | undefined;


  constructor(private service: BooksService,
              private route: ActivatedRoute,
              private fb: FormBuilder,
              private shopService: ShopService,
              private router: Router) {


  }

  ngOnInit(): void {
    const jwt = localStorage.getItem("id_token");
    const userId = localStorage.getItem("userId");

    if (jwt && userId) {
      this.jwt = jwt;
      this.userId = Number(userId);

      this.form.controls['jwt'].setValue(jwt);
      this.form.controls['userId'].setValue(userId);
    }
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.book$ = this.service.book(id);
      this.book$.subscribe(book => {
        this.form.controls['bookId'].setValue(book.id);
        this.form.controls['amount'].setValue(book.price);
        this.form.controls['weight'].setValue(book.weight);
      });
    }
  }

  submit() {
    const val = this.form.value;
    console.log(val);
    this.shopService.buy(val).subscribe(result => {
      console.log(result);
      this.router.navigate([`/books`]);
    })
  }

}
