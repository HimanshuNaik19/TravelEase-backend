# TravelEase - Comprehensive Travel Management System

## Overview
TravelEase is a robust backend application designed to manage travel-related services including flight bookings, hotel reservations, travel packages, and more. Built with Spring Boot, this application provides a secure and scalable solution for travel management.

## Features

- **Flight Management**: Search and book flights with various filtering options
- **Hotel Booking**: Find and reserve hotels at your travel destinations
- **Travel Packages**: Explore and book pre-packaged travel deals
- **User Authentication**: Secure user registration and login system
- **Booking Management**: Track and manage all your travel bookings in one place
- **RESTful API**: Well-documented endpoints for easy integration with frontend applications

## Tech Stack

- **Backend**: Java 17, Spring Boot 3.x
- **Security**: Spring Security, JWT Authentication
- **Database**: (To be configured in application.properties)
- **Build Tool**: Maven
- **API Documentation**: (Consider adding SpringDoc OpenAPI)

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- MySQL/PostgreSQL (or your preferred database)
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd TravelEase
   ```

2. **Configure the database**
   - Update the `application.properties` file with your database credentials
   - Create a new database with the specified name

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   - The application will be available at `http://localhost:8080`
   - API documentation (if configured) will be available at `http://localhost:8080/swagger-ui.html`

## Project Structure

```
src/
├── main/
│   ├── java/com/himanshu/TravelEase/
│   │   ├── config/         # Configuration classes (Security, Web, etc.)
│   │   ├── controller/     # REST controllers
│   │   ├── model/          # Entity classes
│   │   ├── repository/     # Data access layer
│   │   ├── service/        # Business logic
│   │   └── TravelEaseApplication.java  # Main application class
│   └── resources/
│       ├── application.properties  # Application configuration
│       └── static/         # Static resources
└── test/                   # Test files
```

## API Documentation

API documentation is available using Swagger UI after setting up the application. Access it at:
`http://localhost:8080/swagger-ui.html`

## Security

The application uses JWT (JSON Web Tokens) for authentication. Include the JWT token in the Authorization header for protected endpoints:

```
Authorization: Bearer your-jwt-token-here
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any queries or support, please contact:
- Himanshu Naik
- naikhimanshu235@gmail.com
- [Project Repository](https://github.com/himanshunaik19/TravelEase)

---

*This README is a work in progress. Please update it as the project evolves.*
