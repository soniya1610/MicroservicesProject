# 📚 Microservices REST API Project

A Java Spring Boot Microservices project demonstrating communication between multiple services using REST APIs.

## 📌 Overview

This project is built using the Microservices architecture, where each service has a separate responsibility and communicates with other services through REST APIs.

The project contains three independent Spring Boot applications:

- **MicroWebservice-Authors** – Manages author-related operations.
- **MicroWebservice-Book** – Manages book-related operations.
- **MicroWebserviceClient-BookApp** – Acts as the client service that consumes REST APIs from the Author and Book services.

---

## 🏗️ Project Structure

```
MicroservicesProject
│
├── MicroWebservice-Authors
│
├── MicroWebservice-Book
│
├── MicroWebserviceClient-BookApp
│
└── README.md
```

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Web
- REST APIs
- Maven
- STS (Spring Tool Suite)
- Postman
- MySQL (if configured)

---

## 📂 Microservices

### 1️⃣ Author Service

Responsible for author-related operations.

Example Endpoints:

```
GET /author/getAuthors

GET /author/searchAuthors/{name}
```

Default Port:

```
3333
```

---

### 2️⃣ Book Service

Responsible for book-related operations.

Example Endpoints:

```
GET /book/getBooks

GET /book/searchBooks/{name}
```

Default Port:

```
2222
```

---

### 3️⃣ Client Service

Consumes APIs from both Author Service and Book Service and returns the combined response.

Default Port:

```
4444
```

---

## 🔄 Microservice Communication

```
                 Client Service
                        |
             ---------------------
             |                   |
             | REST API Calls    |
             ↓                   ↓
       Author Service      Book Service
```

The Client Service communicates with the Author and Book services using REST APIs.

---

## ▶️ Running the Project

Run the services in the following order:

1. MicroWebservice-Authors
2. MicroWebservice-Book
3. MicroWebserviceClient-BookApp

After all services start successfully, test the APIs using Postman.

---

## 🧪 API Testing

Use Postman to test the REST endpoints.

Example:

```
GET http://localhost:8081/author/getAuthors

GET http://localhost:8082/book/getBooks

GET http://localhost:8083/...
```

---

## 📖 Learning Objectives

- Microservices Architecture
- RESTful Web Services
- Spring Boot
- Inter-service Communication
- API Testing using Postman
- Layered Architecture

---

## 👩‍💻 Author

**Soniya Meena**

GitHub: https://github.com/soniya1610
