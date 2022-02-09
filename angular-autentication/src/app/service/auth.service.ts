import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import * as moment from "moment";
import {Auth} from "../model/auth.model";
import {catchError, Observable, of, Subject, tap} from "rxjs";
import {URL} from "../constants/app-url";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpOptions = {
    headers: new HttpHeaders({'accept': 'application/json'})
  };
  private loggedIn: boolean = false;
  private logger = new Subject<boolean>();


  constructor(private http: HttpClient,
              private router: Router) {

  }

  isLoggedIn(): Observable<boolean> {
    return this.logger.asObservable();
  }


  login(username: string, password: string) {
    return this.http.post<Auth>(`${URL.Login}`, {username, password}, this.httpOptions)
      .pipe(
        tap(_=>console.log("login")),
        catchError((error) => {
          console.log("error")
           return of(error);
        }
          ),

      );
    // this is just the HTTP call,
      // we still need to handle the reception of the token
      //.shareReplay();
  }

  LoginSucces(auth: Auth) {
    this.setSession(auth);
    this.loggedIn = true;
    this.logger.next(this.loggedIn)
  }

  private setSession(authResult: Auth) {
    console.log(moment(authResult.expiresIn).format('MMMM Do YYYY, h:mm:ss a'));
    const expiresAt = moment(authResult.expiresIn)
    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    localStorage.setItem("userId", authResult.userId);
  }

  logout(){
    localStorage.removeItem("id_token");
    localStorage.removeItem("expires_at");
    localStorage.removeItem("userId");
    this.loggedIn = false;
    this.logger.next(this.loggedIn)
    this.router.navigate([ `/login`]);
  }

 /* public isLoggedIn() {
    return moment().isBefore(this.getExpiration());
  }*/
/*
  getExpiration() {
    const expiration = localStorage.getItem("expires_at");
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }
*/



}
