export interface LoginRequest {
  email: string;
  password: string;
}

export interface RegisterRequest {
  nom: string;
  email: string;
  age: number;
  password: string;
}

export interface AuthResponse {
  token: any;
}