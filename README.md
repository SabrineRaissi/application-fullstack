# 🚀 User Management Full Stack Application: Angular-18-Spring-Boot-CRUD-Full-Stack-App_docker-chatbot

[![CI/CD]https://github.com/SabrineRaissi/application-fullstack/actions
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-18-red.svg)](https://angular.io/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg)](https://www.docker.com/)
[![JWT](https://img.shields.io/badge/JWT-Authentication-yellow.svg)](https://jwt.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

> Application Full Stack moderne pour la gestion d'utilisateurs avec authentification JWT, CI/CD, Docker, et assistant IA intégré.

![Demo](https://via.placeholder.com/800x400.png?text=Application+Screenshot)

---

## 📋 Table des Matières

- [Aperçu](#-aperçu)
- [Fonctionnalités](#-fonctionnalités)
- [Technologies](#-technologies)
- [Architecture](#-architecture)
- [Installation](#-installation)
- [Utilisation](#-utilisation)
- [API Documentation](#-api-documentation)
- [Docker](#-docker)
- [CI/CD](#-cicd)
- [Tests](#-tests)
- [Contributions](#-contributions)
- [Auteur](#-auteur)
- [Licence](#-licence)

---

## 🎯 Aperçu

Application Full Stack professionnelle démontrant les meilleures pratiques du développement web moderne :
- **Backend**: API REST Spring Boot avec architecture en couches
- **Frontend**: Interface Angular 18 avec Tailwind CSS
- **Sécurité**: Authentification JWT avec Spring Security
- **DevOps**: Docker, Docker Compose, GitHub Actions CI/CD
- **IA**: Assistant conversationnel Hugging Face intégré
- **Base de données**: PostgreSQL en production, H2 en développement



## ✨ Fonctionnalités

### Backend (Spring Boot)
- ✅ **CRUD complet** sur les utilisateurs
- ✅ **Authentification JWT** sécurisée (Register/Login)
- ✅ **Spring Security** avec protection des routes
- ✅ **Validation des données** avec Bean Validation
- ✅ **Gestion des erreurs** globale
- ✅ **Documentation Swagger/OpenAPI** interactive
- ✅ **Support PostgreSQL et H2**
- ✅ **Tests unitaires** (JUnit, Mockito)
- ✅ **Chatbot IA** avec Hugging Face API

### Frontend (Angular)
- ✅ **Interface moderne** avec Tailwind CSS
- ✅ **Authentification** complète (Login/Register/Logout)
- ✅ **Guard de route** pour protection des pages
- ✅ **Intercepteur HTTP** automatique pour JWT
- ✅ **Gestion d'état** réactive
- ✅ **Notifications** de succès/erreur
- ✅ **Responsive design** mobile-friendly
- ✅ **Assistant IA conversationnel**

### DevOps
- ✅ **Dockerisé** (Backend + Frontend + Database)
- ✅ **Docker Compose** pour orchestration
- ✅ **CI/CD** avec GitHub Actions
- ✅ **Multi-stage builds** optimisés
- ✅ **Health checks** et monitoring

---

## 🛠 Technologies

### Backend
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen?style=for-the-badge&logo=spring)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.3-green?style=for-the-badge&logo=spring-security)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=for-the-badge&logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-Authentication-yellow?style=for-the-badge&logo=json-web-tokens)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green?style=for-the-badge&logo=swagger)

### Frontend
![Angular](https://img.shields.io/badge/Angular-18-red?style=for-the-badge&logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5.5-blue?style=for-the-badge&logo=typescript)
![Tailwind CSS](https://img.shields.io/badge/Tailwind%20CSS-3.4-38B2AC?style=for-the-badge&logo=tailwind-css)
![RxJS](https://img.shields.io/badge/RxJS-7.8-B7178C?style=for-the-badge&logo=reactivex)

### DevOps & IA
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions)
![Hugging Face](https://img.shields.io/badge/Hugging%20Face-AI-FFD21E?style=for-the-badge&logo=huggingface)

---

## 🏗 Architecture

```
┌─────────────────────────────────────────────────────────┐
│                    Frontend (Angular)                    │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐  │
│  │  Components  │  │   Services   │  │    Guards    │  │
│  └──────────────┘  └──────────────┘  └──────────────┘  │
└────────────────────────┬────────────────────────────────┘
                         │ HTTP/JWT
┌────────────────────────┴────────────────────────────────┐
│              Backend (Spring Boot REST API)              │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐  │
│  │ Controllers  │  │   Services   │  │    Filters   │  │
│  ├──────────────┤  ├──────────────┤  ├──────────────┤  │
│  │    DTOs      │  │ Repositories │  │   Security   │  │
│  └──────────────┘  └──────────────┘  └──────────────┘  │
└────────────────────────┬────────────────────────────────┘
                         │ JPA/Hibernate
┌────────────────────────┴────────────────────────────────┐
│                Database (PostgreSQL/H2)                  │
└──────────────────────────────────────────────────────────┘
```

### Architecture en couches (Backend)
```
Controller Layer → Service Layer → Repository Layer → Database
       ↓               ↓                  ↓
    REST API      Business Logic    Data Access
```

---

## 📦 Installation

### Prérequis
- **Java 21+** ([Télécharger](https://adoptium.net/))
- **Node.js 20+** ([Télécharger](https://nodejs.org/))
- **Docker & Docker Compose** ([Télécharger](https://www.docker.com/))
- **Git** ([Télécharger](https://git-scm.com/))

### 1️⃣ Cloner le repository
```bash
git clone https://github.com/VOTRE_USERNAME/user-management-fullstack.git
cd user-management-fullstack
```

### 2️⃣ Configuration

#### Backend
Créez `monprojet/src/main/resources/application.properties` :
```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/usersdb
spring.datasource.username=admin
spring.datasource.password=admin123

# Hugging Face API (optionnel pour le chatbot)
huggingface.api.token=VOTRE_TOKEN_ICI
```

#### Frontend
Créez `frontend-app/src/environments/environment.ts` :
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
```

---

## 🚀 Utilisation

### Option 1: Avec Docker (Recommandé)

```bash
# Lancer toute l'application (Backend + Frontend + Database)
docker-compose up --build

# Accès:
# - Frontend: http://localhost:4200
# - Backend API: http://localhost:8080
# - Swagger UI: http://localhost:8080/swagger-ui.html
```

### Option 2: Sans Docker

#### Backend
```bash
cd monprojet
./mvnw spring-boot:run
```

#### Frontend
```bash
cd frontend-app
npm install
ng serve
```

### Option 3: Build de production

#### Backend
```bash
cd monprojet
./mvnw clean package
java -jar target/*.jar
```

#### Frontend
```bash
cd frontend-app
npm run build
# Les fichiers sont dans dist/
```

---

## 📚 API Documentation

### Swagger UI
Une fois l'application lancée, accédez à la documentation interactive :
👉 **http://localhost:8080/swagger-ui.html**

### Endpoints principaux

#### 🔐 Authentification
```http
POST /api/auth/register
POST /api/auth/login
```

#### 👤 Utilisateurs (JWT requis)
```http
GET    /api/users          # Liste tous les utilisateurs
GET    /api/users/{id}     # Détails d'un utilisateur
POST   /api/users          # Créer un utilisateur
PUT    /api/users/{id}     # Modifier un utilisateur
DELETE /api/users/{id}     # Supprimer un utilisateur (ADMIN)
```

#### 🤖 Chatbot IA (JWT requis)
```http
POST   /api/chatbot/chat   # Poser une question à l'IA
```

### Exemples de requêtes

#### Register
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "password": "password123"
  }'
```

#### Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123"
  }'
```

#### Get Users (avec JWT)
```bash
curl http://localhost:8080/api/users \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

---

## 🐳 Docker

### Structure
```
├── monprojet/Dockerfile          # Backend image
├── frontend-app/Dockerfile       # Frontend image
├── frontend-app/nginx.conf       # Nginx config
└── docker-compose.yml            # Orchestration
```

### Commandes utiles

```bash
# Build et démarrer
docker-compose up --build

# Démarrer en arrière-plan
docker-compose up -d

# Voir les logs
docker-compose logs -f

# Arrêter
docker-compose down

# Arrêter et supprimer les volumes
docker-compose down -v

# Rebuild une image spécifique
docker-compose build backend
docker-compose build frontend
```

### Images Docker
- **Backend**: Multi-stage build avec Maven et JRE Alpine
- **Frontend**: Build Angular + Nginx Alpine
- **Database**: PostgreSQL 16 Alpine officiel

---

## ⚙️ CI/CD

### GitHub Actions Pipeline

Le workflow `.github/workflows/ci-cd.yml` exécute automatiquement :

1. **Backend CI**
   - Checkout du code
   - Setup Java 21
   - Cache Maven
   - Build avec Maven
   - Tests unitaires

2. **Frontend CI**
   - Checkout du code
   - Setup Node.js 20
   - Installation des dépendances
   - Build Angular
   - Lint

3. **Docker Build**
   - Build des images Docker
   - Test docker-compose config

4. **Security Scan**
   - Analyse de vulnérabilités avec Trivy



---

## 🧪 Tests

### Backend
```bash
cd monprojet
./mvnw test
./mvnw verify
```

### Frontend
```bash
cd frontend-app
npm test
npm run lint
```

### Coverage
```bash
# Backend
./mvnw test jacoco:report

# Frontend
ng test --code-coverage


---

## 🗺 Roadmap

- [ ] Ajout de tests E2E (Cypress)
- [ ] Déploiement automatique (AWS/Azure)
- [ ] Monitoring avec Prometheus + Grafana
- [ ] Notification par email
- [ ] Export Excel/PDF
- [ ] Authentification OAuth2 (Google, GitHub)
- [ ] Mode sombre
- [ ] Internationalisation (i18n)
- [ ] Pagination côté serveur
- [ ] WebSocket pour temps réel

---

## 🤝 Contributions

Les contributions sont les bienvenues !

1. Fork le projet
2. Créez une branche (`git checkout -b feature/AmazingFeature`)
3. Commit (`git commit -m 'Add AmazingFeature'`)
4. Push (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

---

## 👨‍💻 Auteur

- GitHub: https://github.com/SabrineRaissi
- Email: contact.sabrineraissi@gmail.com

---

## 📄 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 🙏 Remerciements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Angular](https://angular.io/)
- [Tailwind CSS](https://tailwindcss.com/)
- [Hugging Face](https://huggingface.co/)
- [Docker](https://www.docker.com/)


---

⭐ **Si ce projet vous a aidé, n'oubliez pas de lui mettre une étoile !** ⭐

