import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


export interface User {
  id?: number;
  nom: string;
  email: string;
  age: number;
}
@Injectable({
  providedIn: 'root'
})
export class UserService {
    private apiUrl = 'http://localhost:8080/api/users/';
    constructor(private http: HttpClient) {  }
    getUsers() {
        return this.http.get<User[]>(this.apiUrl+"all");
    }
    createUser(user: User) {
        return this.http.post<User>(`${this.apiUrl}`, user);
    }
    updateUser(id: number, user: User) {
        return this.http.put<User>(`${this.apiUrl}update/${id}`, user);
    }
    deleteUser(id: number) {
        return this.http.delete(`${this.apiUrl}delete/${id}`);
    }
    getUserById(id: number) {
        return this.http.get<User>(`${this.apiUrl}${id}`);
    }

  
}
