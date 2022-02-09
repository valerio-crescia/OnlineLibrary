import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {}
  private static addToken(request: HttpRequest<any>, token: string): HttpRequest<any> {
    return request.clone({
      headers: request.headers.set('X-Auth', `Bearer ${token}`)
    });
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const idToken = localStorage.getItem("id_token");

    if(idToken){
      return next.handle(AuthInterceptor.addToken(req, idToken))
    } else {
      return next.handle(req);
    }

  }

}
