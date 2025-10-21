import { Component, OnInit } from '@angular/core';
import { User, UserService } from '../../services/user.service';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
   imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './user-list.html',
  styleUrl: './user-list.css'
})
export class UserList implements OnInit {

  users:User[] = [];
 // Simulate fetching users from an API
    listUsers = [
      { id: 1, nom: 'Alice Smith', email: 'alice@example.com', age:30 },
      { id: 2, nom: 'Bob Johnson', email: 'bob@example.com', age:22 },
      { id: 3, nom: 'Charlie Brown', email: 'charlie@example.com', age:28 }
    ];
      newUser: User = { nom: '', email: '', age: 0 };


    constructor(private userService: UserService, private router :Router, private authService:AuthService) { }
  ngOnInit(): void {
  // this.users = this.listUsers;
  this.loadUsers();
  }
  loadUsers() {
   this.userService.getUsers().subscribe((data) => {
     this.users = data;
   });
  }
  getUserById(id: number) {
    this.userService.getUserById(id).subscribe((data) => {
      console.log(data);
    });
  }
  createUser() {
    //const newUser: User = { nom: 'New User', email: 'test@gmail.com', age: 10 };
    this.userService.createUser(this.newUser).subscribe((data) => {
      console.log('User created:', data);
       this.loadUsers(); // Refresh the list
     //   alert(`User Details:\nName: ${data.nom}\nEmail: ${data.email}\nAge: ${data.age}`);
    alert('User added successfully!');
    this.newUser={ nom: '', email: '', age: 0 };
    });
  }
  updateUser(id: number) {
    const updatedUser: User = { nom: 'Updated User', email: '', age: 0 };
    this.userService.updateUser(id, updatedUser).subscribe((data) => {
      console.log('User updated:', data);
      alert('User updated successfully!');
    this.newUser={ nom: '', email: '', age: 0 };
   
      this.loadUsers(); // Refresh the list
    });
  }
  deleteUser(id: number) {
    this.userService.deleteUser(id).subscribe(() => {
      console.log('User deleted');
      this.loadUsers(); // Refresh the list
    });
  }
  showUser(user: User) {
   // alert(`User Details:\nName: ${user.nom}\nEmail: ${user.email}\nAge: ${user.age}`);
    this.newUser=user;
  }
    logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
