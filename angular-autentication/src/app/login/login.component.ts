import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validator, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";
import {Auth} from "../model/auth.model";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form = this.fb.group({
    username: ['',Validators.required],
    password: ['', Validators.required]
  })

  constructor(private fb: FormBuilder,
              private authService: AuthService,
              private router: Router
  ) {

  }
  ngOnInit(): void {

  }

  submit(){
    this.login()
  }

  login() {
    const val = this.form.value;

    if(val.username && val.password) {
      this.authService.login(val.username, val.password)
        .subscribe(
          (auth: Auth) => {
            this.authService.LoginSucces(auth)
            this.gotoBooks()
          })

    }
  }

  gotoBooks() {
    this.router.navigate(['/books']);
  }




}
