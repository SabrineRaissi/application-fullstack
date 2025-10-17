import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, RouterModule } from '@angular/router';
import { RegisterRequest } from '../../models/auth.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
 registerData: RegisterRequest = { 
    nom: '', 
    email: '', 
    age: 0, 
    password: '' 
  };
  errorMessage = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}
  onRegister() {
    this.authService.register(this.registerData).subscribe({
      next: () => {
        this.router.navigate(['/users']);
      },
      error: (err) => {
        this.errorMessage = 'Erreur lors de l\'inscription';
        console.error(err);
      }
    });
  }
}
