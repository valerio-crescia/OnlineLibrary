import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "./service/auth.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Libreria Online';
  islogged$ : Observable<boolean>;

  constructor(private router: Router,
              private service: AuthService) {
    this.islogged$ = service.isLoggedIn();
  }
  ngOnInit(): void {

  }

  logout(){
    this.service.logout();
  }




}


