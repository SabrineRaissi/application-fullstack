import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Register } from './components/register/register';
import { UserList } from './components/user-list/user-list';
import { authGuard } from './guards/auth.guard';
import { Chatbot } from './components/chatbot/chatbot';

export const routes: Routes = [  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'register', component: Register },
  { path: 'users', component: UserList, canActivate: [authGuard] },
    { path: 'chatbot', component: Chatbot, canActivate: [authGuard] },
  { path: '**', redirectTo: '/login' }];
