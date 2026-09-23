# 📚 Microservices REST API - Book Management System

## 🎯 Problem Statement

Traditional monolithic architectures become hard to maintain and scale as applications grow. This project demonstrates how to break down a complex application into independent microservices that communicate via REST APIs, following the Microservices Architecture Pattern.

## 💡 Solution

Built a distributed system with three independent Spring Boot services:
- **Author Service** - Manage author data independently
- **Book Service** - Handle book operations autonomously  
- **Client Service** - Orchestrate requests across services using RestTemplate

---

## 🏗️ Architecture Overview

```
┌─────────────────────────────────────────┐
│     Client Application (Port 4444)      │
│   (API Gateway / Service Orchestrator)  │
└────────────┬────────────────────────────┘
             │ 
        REST API Calls (HTTP)
        
      ┌──────────┴──────────┐
      │                     │
┌─────▼──────────┐  ┌──────▼──────────┐
│   Author       │  │     Book        │
│  Service       │  │   Service       │
│ (Port 3333)    │  │  (Port 2222)    │
│                │  │                 │
│ ┌────────────┐ │  │ ┌────────────┐ │
│ │  Authors   │ │  │ │   Books    │ │
│ │   Logic    │ │  │ │   Logic    │ │
│ └────────────┘ │  │ └────────────┘ │
└────────────────┘  └─────────────────┘
```

---

## ⚙️ Tech Stack

| Component | Technology | Purpose |
|-----------|-----------|---------|
| **Language** | Java 11+ | Backend development |
| **Framework** | Spring Boot 2.x | Microservices framework |
| **Web** | Spring Web MVC | REST API development |
| **APIs** | RESTful Web Services | Service-to-service communication |
| **HTTP Client** | RestTemplate | Make HTTP calls between services |
| **Build Tool** | Maven | Project build & dependency management |
| **IDE** | IntelliJ IDEA / STS / VS Code | Development environment |
| **Testing** | Postman | API endpoint testing |
| **Architecture** | Layered (Controller → Service → Repository) | Code organization |

---

## 📦 Project Structure

```
MicroservicesProject/
│
├── MicroWebservice-Authors (Port 3333)
│   ├── src/main/java/com/example/authors/
│   │   ├── controller/
│   │   │   └── AuthorController.java          (REST Endpoints)
│   │   ├── service/
│   │   │   └── AuthorService.java             (Business Logic)
│   │   ├── model/
│   │   │   └── Author.java                    (POJO)
│   │   ├── repository/
│   │   │   └── AuthorRepository.java          (Data Access)
│   │   └── AuthorsServiceApplication.java
│   ├── pom.xml
│   └── application.properties
│
├── MicroWebservice-Book (Port 2222)
│   ├── src/main/java/com/example/book/
│   │   ├── controller/
│   │   │   └── BookController.java            (REST Endpoints)
│   │   ├── service/
│   │   │   └── BookService.java               (Business Logic)
│   │   ├── model/
│   │   │   └── Book.java                      (POJO)
│   │   ├── repository/
│   │   │   └── BookRepository.java            (Data Access)
│   │   └── BookServiceApplication.java
│   ├── pom.xml
│   └── application.properties
│
├── MicroWebserviceClient-BookApp (Port 4444)
│   ├── src/main/java/com/example/client/
│   │   ├── controller/
│   │   │   └── ClientController.java          (API Gateway)
│   │   ├── service/
│   │   │   └── ClientService.java             (Orchestration Logic)
│   │   ├── config/
│   │   │   └── RestTemplateConfig.java        (HTTP Client Setup)
│   │   └── ClientApplicationClass.java
│   ├── pom.xml
│   └── application.properties
│
├── .gitignore
├── README.md
└── LICENSE
```

---

## 🛠️ Prerequisites

Before running the project, ensure you have the following installed:

- **Java Development Kit (JDK):** Version 11 or higher
  ```bash
  java -version
  ```

- **Apache Maven:** Version 3.6 or higher
  ```bash
  mvn -version
  ```

- **IDE:** IntelliJ IDEA / Spring Tool Suite (STS) / VS Code with Java extensions

- **API Testing Tool:** Postman or Insomnia

- **Git:** For version control
  ```bash
  git --version
  ```

---

## 🚀 Setup & Installation Guide

### Step 1: Clone the Repository

```bash
git clone https://github.com/soniya1610/MicroservicesProject.git
cd MicroservicesProject
```

---

### Step 2: Run Author Service (Port 3333)

**Open Terminal/Command Prompt:**

```bash
cd MicroWebservice-Authors
```

**Build the project:**
```bash
mvn clean install
```

**Run the service:**
```bash
mvn spring-boot:run
```

**Expected Output:**
```
Tomcat started on port(s): 3333
Started AuthorsServiceApplication in X seconds
```

✅ **Author Service is running on:** `http://localhost:3333`

---

### Step 3: Run Book Service (Port 2222)

**Open New Terminal/Command Prompt:**

```bash
cd MicroWebservice-Book
```

**Build the project:**
```bash
mvn clean install
```

**Run the service:**
```bash
mvn spring-boot:run
```

**Expected Output:**
```
Tomcat started on port(s): 2222
Started BookServiceApplication in X seconds
```

✅ **Book Service is running on:** `http://localhost:2222`

---

### Step 4: Run Client Service (Port 4444)

**Open New Terminal/Command Prompt:**

```bash
cd MicroWebserviceClient-BookApp
```

**Build the project:**
```bash
mvn clean install
```

**Run the service:**
```bash
mvn spring-boot:run
```

**Expected Output:**
```
Tomcat started on port(s): 4444
Started ClientApplicationClass in X seconds
```

✅ **Client Service is running on:** `http://localhost:4444`

---

## 📡 API Endpoints Documentation

### Author Service (Port 3333)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/author/getAuthors` | Get all authors |
| GET | `/author/searchAuthors/{name}` | Search authors by name |
| POST | `/author/add` | Add new author |
| PUT | `/author/update/{id}` | Update author details |
| DELETE | `/author/delete/{id}` | Delete author by ID |

**Example Requests:**

```bash
# Get all authors
curl -X GET http://localhost:3333/author/getAuthors

# Search author by name
curl -X GET "http://localhost:3333/author/searchAuthors/John"

# Add new author
curl -X POST http://localhost:3333/author/add \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "John Smith", "email": "john@example.com"}'
```

---

### Book Service (Port 2222)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/book/getBooks` | Get all books |
| GET | `/book/searchBooks/{name}` | Search books by title |
| POST | `/book/add` | Add new book |
| PUT | `/book/update/{id}` | Update book details |
| DELETE | `/book/delete/{id}` | Delete book by ID |

**Example Requests:**

```bash
# Get all books
curl -X GET http://localhost:2222/book/getBooks

# Search book by title
curl -X GET "http://localhost:2222/book/searchBooks/Java"

# Add new book
curl -X POST http://localhost:2222/book/add \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "title": "Java Programming", "authorId": 1, "isbn": "123456789"}'
```

---

### Client Service (Port 4444) - API Gateway

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/client/getAllData` | Get all books with author details |
| GET | `/client/getBooksByAuthor/{authorId}` | Get books by specific author |
| POST | `/client/createBookWithAuthor` | Create book with author info |

**Example Requests:**

```bash
# Get combined data (books + authors)
curl -X GET http://localhost:4444/client/getAllData

# Get books by specific author
curl -X GET "http://localhost:4444/client/getBooksByAuthor/1"

# Create book with author
curl -X POST http://localhost:4444/client/createBookWithAuthor \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Spring Boot Guide",
    "authorId": 1,
    "authorName": "John Smith"
  }'
```

---

## 🔄 Request Flow Explanation

### Scenario: Get all books with author details

```
1. User sends request:
   GET http://localhost:4444/client/getAllData

2. Client Service receives request
   └─ ClientController.getAllData()

3. Client Service makes parallel/sequential calls:
   ├─ Call Author Service: GET http://localhost:3333/author/getAuthors
   │  └─ Response: List of authors
   │
   └─ Call Book Service: GET http://localhost:2222/book/getBooks
      └─ Response: List of books

4. Client Service combines responses:
   └─ Maps books to corresponding authors
   └─ Creates combined response object

5. Returns unified JSON response to user:
   {
     "books": [...],
     "authors": [...]
   }
```

### Code Example (RestTemplate usage in Client Service):

```java
@Service
public class ClientService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    private String authorServiceURL = "http://localhost:3333";
    private String bookServiceURL = "http://localhost:2222";
    
    public CombinedResponse getAllData() {
        // Call Author Service
        Author[] authors = restTemplate.getForObject(
            authorServiceURL + "/author/getAuthors",
            Author[].class
        );
        
        // Call Book Service
        Book[] books = restTemplate.getForObject(
            bookServiceURL + "/book/getBooks",
            Book[].class
        );
        
        // Combine responses
        return new CombinedResponse(authors, books);
    }
}
```

---

## 🧪 Testing with Postman

### Import Collection

1. Open **Postman**
2. Click **Import** → Select **Link** tab
3. Paste: `[Your collection link if available]`
4. Click **Import**

### Manual Testing Steps

#### Test 1: Author Service
```
1. Create new GET request
   URL: http://localhost:3333/author/getAuthors
   
2. Send request
   
3. Expected Response (200 OK):
   [
     {"id": 1, "name": "Author Name", "email": "email@example.com"},
     ...
   ]
```

#### Test 2: Book Service
```
1. Create new GET request
   URL: http://localhost:2222/book/getBooks
   
2. Send request
   
3. Expected Response (200 OK):
   [
     {"id": 1, "title": "Book Title", "authorId": 1, "isbn": "123456789"},
     ...
   ]
```

#### Test 3: Client Service (Aggregation)
```
1. Create new GET request
   URL: http://localhost:4444/client/getAllData
   
2. Send request
   
3. Expected Response (200 OK):
   {
     "books": [...],
     "authors": [...]
   }
```

---

## 💡 Key Microservices Concepts Demonstrated

### 1. **Service Independence**
```
Each service:
✓ Has its own database (logical separation)
✓ Manages its own business logic
✓ Can be deployed independently
✓ Can be scaled independently
```

### 2. **Loose Coupling**
```
Services communicate ONLY via REST APIs
- Changes in one service don't directly affect others
- Services don't share code or database
- Communication happens through well-defined contracts
```

### 3. **Service-to-Service Communication**
```
RestTemplate Pattern:
┌─────────────┐         HTTP Request        ┌──────────────┐
│   Client    │ ──────────────────────────► │  Author      │
│   Service   │                             │  Service     │
│             │ ◄────────────────────────── │              │
│             │         JSON Response       │              │
└─────────────┘                             └──────────────┘
```

### 4. **API Gateway Pattern**
```
Client Service acts as API Gateway:
- Single entry point for clients
- Routes requests to appropriate services
- Combines/transforms responses
- Handles cross-cutting concerns
```

---

## 📊 Microservices Architecture Benefits

| Benefit | Description |
|---------|-------------|
| **Scalability** | Scale only the service that needs it (e.g., Book Service during peak) |
| **Flexibility** | Each service can use different tech stack (Java, Python, Node.js) |
| **Resilience** | Failure in one service doesn't crash entire system |
| **Faster Deployment** | Services can be deployed independently without affecting others |
| **Easy Maintenance** | Smaller codebases are easier to understand and maintain |
| **Team Autonomy** | Teams can work independently on different services |

---

## 🎓 Learning Outcomes

### Microservices Architecture
- ✅ Understand monolithic vs microservices architecture
- ✅ Design independent services with single responsibility
- ✅ Implement inter-service communication via REST APIs
- ✅ Handle distributed system challenges
- ✅ Implement API Gateway pattern

### Spring Boot Development
- ✅ Create REST APIs using Spring Web MVC
- ✅ Implement layered architecture (Controller → Service → Repository)
- ✅ Use RestTemplate for HTTP communication
- ✅ Configure multiple Spring Boot applications
- ✅ Handle dependency injection and component scanning

### Best Practices
- ✅ REST API design principles
- ✅ Proper error handling in distributed systems
- ✅ Logging and debugging across services
- ✅ Port management and service configuration
- ✅ API versioning and backward compatibility

---

## 🛡️ Challenges & Solutions

| Challenge | Solution |
|-----------|----------|
| **Network Latency** | Implement caching, async calls, circuit breaker pattern |
| **Service Failure** | Implement retry logic, fallback mechanisms, health checks |
| **Data Consistency** | Use eventual consistency, implement saga pattern |
| **Distributed Tracing** | Use correlation IDs, centralized logging (ELK Stack) |
| **Configuration Management** | Use Spring Cloud Config for centralized config |

---

## 📈 Future Enhancements

- [ ] **Database Integration** - Add MySQL/PostgreSQL for persistent storage
- [ ] **Service Discovery** - Implement Eureka for dynamic service registration
- [ ] **API Gateway** - Use Spring Cloud Gateway for advanced routing
- [ ] **Circuit Breaker** - Implement Hystrix for fault tolerance
- [ ] **Distributed Tracing** - Use Spring Cloud Sleuth + Zipkin
- [ ] **Centralized Logging** - Implement ELK Stack (Elasticsearch, Logstash, Kibana)
- [ ] **Unit Tests** - Add JUnit + Mockito for testing
- [ ] **Integration Tests** - Add TestContainers for service testing
- [ ] **Containerization** - Dockerize all services
- [ ] **Orchestration** - Deploy on Kubernetes (K8s)
- [ ] **Message Queue** - Implement RabbitMQ/Kafka for async communication
- [ ] **API Documentation** - Add Swagger/OpenAPI documentation

---

## 🔍 Troubleshooting

### Issue 1: Port Already in Use
```
Error: Address already in use: bind
Solution: Change port in application.properties
          server.port=3333
          
Or kill existing process:
          Windows: netstat -ano | findstr :3333
          Linux/Mac: lsof -i :3333
```

### Issue 2: Service Not Found / Connection Refused
```
Error: Connection refused when calling another service
Solution: 
1. Verify all services are running
2. Check if ports match (3333, 2222, 4444)
3. Verify RestTemplate URL is correct
4. Check firewall settings
```

### Issue 3: RestTemplate Returns Null
```
Error: RestTemplate.getForObject() returns null
Solution:
1. Verify endpoint URL is correct
2. Check if service is running on expected port
3. Verify response object mapping matches API response
4. Check @Bean RestTemplate configuration
```

---

## 👨‍💻 My Contributions

- ✅ **Designed microservices architecture** with 3 independent services
- ✅ **Implemented REST APIs** for Author and Book services with CRUD operations
- ✅ **Set up inter-service communication** using RestTemplate
- ✅ **Created layered architecture** (Controller → Service → Repository)
- ✅ **Implemented proper error handling** and validation
- ✅ **Configured multiple Spring Boot applications** with different ports
- ✅ **Tested all endpoints** using Postman
- ✅ **Documented APIs** with detailed endpoint descriptions

---

## 📚 Resources & References

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Microservices Patterns](https://microservices.io/patterns/index.html)
- [REST API Design Best Practices](https://restfulapi.net/)
- [Spring RestTemplate Guide](https://spring.io/guides/gs/consuming-rest/)
- [Building Microservices by Sam Newman](https://samnewman.io/books/building_microservices/)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)

---

## 📝 Code Quality

**Architecture Pattern:** Layered Architecture
```
Request → Controller → Service → Repository → Database
```

**Coding Standards:**
- ✓ Proper naming conventions (camelCase for variables)
- ✓ Single Responsibility Principle
- ✓ DRY (Don't Repeat Yourself)
- ✓ Proper exception handling
- ✓ Clear code comments and documentation

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** - see the LICENSE file for details.

Free for:
- ✓ Personal Projects
- ✓ Educational Purposes
- ✓ Commercial Use
- ✓ Hackathons
- ✓ Portfolio/Resume

---

## 👤 Author

**Soniya Meena**

- 🐙 GitHub: [@soniya1610](https://github.com/soniya1610)
- 💻 LeetCode: [soniya_meena](https://leetcode.com/u/soniya_meena/) (555+ DSA Problems)
- 💼 LinkedIn: [soniya-meena-3bb25b395](https://linkedin.com/in/soniya-meena-3bb25b395)
- 📧 Email: meenasonia243@gmail.com

---

## 🙏 Acknowledgments

- Spring Boot Community
- All contributors and supporters
- GSSoC 2026 for open-source opportunities

---

## ⭐ If this project helped you, please consider giving it a star!

```
╔═════════════════════════════════════════╗
║   Microservices Architecture Practice   ║
║   Learning & Building Real Systems      ║
╚═════════════════════════════════════════╝
```

---

**Last Updated:** September 2026
**Version:** 1.0
**Status:** ✅ Production Ready
