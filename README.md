# 📚 Library Management API

A comprehensive REST API for library management, built with Spring Boot 4.0 and Java 21. The system provides complete functionality for managing books, publishers, users, and loans, with interactive documentation via Swagger.

## 🚀 Technologies

- **Java 21** - Programming language
- **Spring Boot 4.0** - Main framework
- **Spring Data JPA** - Data persistence
- **PostgreSQL** - Relational database
- **Lombok** - Boilerplate code reduction
- **SpringDoc OpenAPI (Swagger)** - API documentation
- **Maven** - Dependency management

## 📋 Features

### 👤 User Management
- Create, retrieve, update, and delete users
- Search users by name (case-insensitive)
- List all users

### 📖 Book Management
- Complete CRUD operations for books
- Search by author, title, or publisher
- Automatic publisher association
- Detailed lookup by ID

### 🏢 Publisher Management
- Publisher registration and management
- Search by name
- Book association

### 📅 Loan System
- Book loan registration
- Loan and return date tracking
- Default 30-day loan period
- Search loans by user or book
- Update and delete loan records

## 🏗️ Architecture

The project follows a well-defined layered architecture:

```
src/main/java/com/ricael/biblioteca/
├── controller/          # REST controllers
├── service/            # Business logic
├── repository/         # Data access layer (JPA)
├── model/              # Domain entities
├── mapper/             # DTO to Entity conversion
├── request/            # Request DTOs
└── response/           # Response DTOs
```

## 🔧 Getting Started

### Prerequisites
- Java 21 or higher
- PostgreSQL installed and running
- Maven 3.6+

### Database Configuration

1. Create a PostgreSQL database: 
```sql
CREATE DATABASE biblioteca;
```

2. Configure credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
spring.datasource.username=your_username
spring.datasource. password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Running the Application

**Using Maven:**
```bash
./mvnw spring-boot:run
```

**Or build and run:**
```bash
./mvnw clean package
java -jar target/biblioteca-0.0.1-SNAPSHOT. jar
```

The application will be available at:  `http://localhost:8080`

## 📚 API Documentation

Access the interactive Swagger UI documentation after starting the application: 

```
http://localhost:8080/swagger-ui.html
```

## 🌐 Main Endpoints

### Users
- `GET /user` - List all users
- `GET /user/{id}` - Get user by ID
- `GET /user/by-name?name={name}` - Search users by name
- `POST /user` - Create new user
- `PATCH /user/{id}` - Update user
- `DELETE /user/{id}` - Delete user

### Books
- `GET /book` - List all books
- `GET /book/{id}` - Get book by ID
- `GET /book/by-author?author={author}` - Search by author
- `GET /book/by-title?title={title}` - Search by title
- `GET /book/by-publisher` - Search by publisher
- `POST /book` - Create new book

### Publishers
- `GET /publisher` - List all publishers
- `GET /publisher/{id}` - Get publisher by ID
- `GET /publisher/by-name?name={name}` - Search by name
- `POST /publisher` - Create new publisher
- `DELETE /publisher/{id}` - Delete publisher

### Loans
- `GET /loan/by-user/{id}` - List loans by user
- `GET /loan/by-book/{id}` - List loans by book
- `POST /loan` - Create new loan
- `PUT /loan/{id}` - Update loan
- `DELETE /loan/{id}` - Delete loan

## 📊 Data Model

### User
```java
{
  "id": Long,
  "name": String,
  "adress": String,
  "phone": String,
  "email":  String
}
```

### Book
```java
{
  "id": Long,
  "title": String,
  "author":  String,
  "isbn": String,
  "publishedYear":  Integer,
  "publisher": Publisher
}
```

### Publisher
```java
{
  "id": Long,
  "name":  String,
  "address": String,
  "phone": String,
  "email": String
}
```

### Loan
```java
{
  "id":  Long,
  "userId": Long,
  "bookId": Long,
  "loanDate":  Instant,
  "returnDate": Instant
}
```

## 🎯 Technical Highlights

- **RESTful Architecture** following best practices
- **DTO Pattern** for data transfer
- **Mappers** for entity-DTO conversion
- **Request Validation** for data integrity
- **Custom Exception Handling** for better error management
- **Automated Documentation** with OpenAPI 3.0
- **Well-defined JPA Relationships** between entities
- **Custom Queries** for specific searches

## 🛠️ Future Enhancements

- [ ] Implement authentication and authorization (Spring Security + JWT)
- [ ] Add automatic late fee calculation
- [ ] Implement book reservation system
- [ ] Add unit and integration tests
- [ ] Implement pagination for listings
- [ ] Add Bean Validation constraints
- [ ] Create notification system (email/SMS)
- [ ] Implement operation auditing

## 👨‍💻 Author

**Ricael Durand** - [GitHub](https://github.com/Durannd)

## 📝 License

This project was developed for educational and portfolio purposes. 

---

⭐ If you found this project useful, please consider giving it a star! 