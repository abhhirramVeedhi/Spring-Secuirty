# 🔐 Spring Security + JWT Authentication API

A secure REST API built using **Spring Boot**, **Spring Security**, **JWT**, and **MySQL** for authentication and authorization.

---

## 🚀 Features

✅ User Registration & Login  
✅ JWT Token Generation & Validation  
✅ Spring Security Authentication  
✅ BCrypt Password Encryption  
✅ Stateless Authentication  
✅ Protected REST APIs  
✅ MySQL Database Integration  

---

## 🛠️ Tech Stack

- ☕ Java 21
- 🌱 Spring Boot
- 🔒 Spring Security
- 🎟️ JWT (JSON Web Token)
- 🗄️ MySQL
- 📦 Maven
- ⚡ Lombok

---

## 📂 Project Structure

```bash
src/main/java/com/security/springSecDemo
├── config
├── controller
├── jwt
├── model
├── repository
├── service
└── SpringSecDemoApplication.java
```

---

## 🔑 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/save` | Register User |
| POST | `/login` | Login User |
| GET | `/hello-secure` | Protected API |

---

## 🔒 Authentication Flow

```text
User Registers
      ↓
Password Encrypted using BCrypt
      ↓
User Login
      ↓
JWT Token Generated
      ↓
Client Sends Token in Header
      ↓
Protected APIs Accessible
```

---

## ⚙️ Configuration

### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_springboot
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

jwt.secret=your_secret_key
```

---

## ▶️ Run The Project

```bash
# Clone Repository
git clone <repo-url>

# Navigate to Project
cd springSecDemo

# Run Application
./mvnw spring-boot:run
```

---

## 🧪 Testing with Postman

### 📌 Register User

```http
POST /save
```

### 📌 Login User

```http
POST /login
```

### 📌 Authorization Header

```http
Authorization: Bearer YOUR_TOKEN
```

---

## 📚 Concepts Covered

- 🔐 Spring Security
- 🎟️ JWT Authentication
- 🔑 SecurityFilterChain
- 🔒 BCryptPasswordEncoder
- 👤 UserDetailsService
- 🌐 REST API Security
- 🗄️ MySQL Integration
