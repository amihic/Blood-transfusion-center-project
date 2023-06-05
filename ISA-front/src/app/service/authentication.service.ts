import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private access_token = null;

  constructor(private http: HttpClient) { }

  authenticate(email: string, password: string) {

    return this.http
      .post<any>("http://localhost:8080/auth/login", { email, password })
      .pipe(
        map((userData) => {
          sessionStorage.setItem("currentUser", JSON.stringify(userData))
          sessionStorage.setItem("email", email);
          let tokenStr = "Bearer " + userData.token.accessToken;
          this.access_token = userData.token.accessToken;
          sessionStorage.setItem("token", tokenStr);
          sessionStorage.setItem("id", userData.id);
          sessionStorage.setItem("role", userData.role);
          sessionStorage.setItem("firstLogin", 'true');
          return userData;
        })
      );
  }
  tokenIsPresent() {
    return this.access_token != undefined && this.access_token != null;
  }

  getToken() {
    return sessionStorage.getItem("token");
  }



  isUserLoggedIn() {
    let email = sessionStorage.getItem("email");
    console.log(!(email === null));
    return !(email === null);
  }

  logOut() {
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("currentUser");
    sessionStorage.removeItem("id");
    sessionStorage.removeItem("role");

  }
}
