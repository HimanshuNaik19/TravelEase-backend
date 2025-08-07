# TravelEase Backend Documentation

## 1. Introduction

Welcome to the backend documentation for **TravelEase**, a comprehensive travel booking application. This document provides all the necessary information to understand, set up, and use the backend services. The application allows users to search for and book flights, hotels, and rental cars, as well as browse and book curated travel packages.

## 2. Technologies Used

*   **Java 21**: Core programming language.
*   **Spring Boot 3**: Application framework for creating stand-alone, production-grade Spring-based applications.
*   **Spring Data JPA**: For simplified data access and repository management with a database.
*   **Spring Web**: For building RESTful web services.
*   **Spring Security**: For robust authentication and access-control.
*   **OAuth2**: For delegated authentication, configured to work with GitHub.
*   **MySQL**: The relational database used for data persistence.
*   **Maven**: For project build automation and dependency management.
*   **Lombok**: To reduce boilerplate code in model classes.

## 3. Project Structure

The project follows a standard layered architecture to ensure a clean separation of concerns:

-   `config`: Contains configuration classes, such as `SecurityConfig` for managing application security.
-   `controller`: Handles all incoming HTTP requests and exposes the REST API endpoints.
-   `model`: Defines the JPA entity classes that map to database tables (e.g., `Flight`, `Hotel`, `Car`).
-   `repository`: Contains Spring Data JPA interfaces for database operations.
-   `service`: Implements the core business logic of the application.

## 4. Setup and Installation

Follow these steps to get the application running on your local machine:

1.  **Clone the Repository**: Clone the project to your local machine.
2.  **Set up MySQL Database**:
    *   Ensure you have MySQL installed and running.
    *   Create a new database named `travelease_db`.
3.  **Configure Application Properties**:
    *   Open `src/main/resources/application.properties`.
    *   Update the database URL, username, and password:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/travelease_db
        spring.datasource.username=your-mysql-username
        spring.datasource.password=your-mysql-password
        ```
    *   Configure your GitHub OAuth2 credentials:
        ```properties
        spring.security.oauth2.client.registration.github.client-id=your-github-client-id
        spring.security.oauth2.client.registration.github.client-secret=your-github-client-secret
        ```
4.  **Set Admin User**:
    *   In `src/main/java/com/himanshu/TravelEase/config/SecurityConfig.java`, replace `"HimanshuNaik19"` with your GitHub username to grant yourself admin privileges.
5.  **Run the Application**:
    *   Open a terminal in the project's root directory.
    *   Run the command: `mvn spring-boot:run`.
    *   The application will start on `http://localhost:8080`.

## 5. Authentication and Authorization

Authentication is handled via OAuth2 with GitHub. Certain endpoints are protected and require specific roles.

*   **Roles**: `USER` (default), `ADMIN`.
*   **Admin Privileges**: Endpoints for creating, updating, or deleting flights, hotels, cars, and packages require the `ADMIN` role.
*   **User Privileges**: Booking endpoints require an authenticated `USER`.
*   **Public Access**: Search and view endpoints are publicly accessible.

### Testing with Postman

1.  **Log in**: Open `http://localhost:8080/` in your browser and log in with your GitHub account.
2.  **Get Cookie**: Use your browser's developer tools to find the `JSESSIONID` cookie for `localhost`.
3.  **Use in Postman**:
    *   In Postman, set the authorization type to **"No Auth"**.
    *   In the **Headers** tab, add a new header: `Cookie` with the value `JSESSIONID=<your_copied_value>`.

## 6. API Endpoints

--- 

### Flights

*   **`GET /api/flights`**
    *   **Description**: Get all available flights.
    *   **Access**: Public

*   **`GET /api/flights/search`**
    *   **Description**: Search for flights by departure and arrival cities.
    *   **Query Parameters**: `departureCity` (string), `arrivalCity` (string).
    *   **Access**: Public

*   **`POST /api/flights`**
    *   **Description**: Add a new flight.
    *   **Access**: `ADMIN`
    *   **Request Body**:
        ```json
        {
            "flightNumber": "FL456",
            "departureCity": "Paris",
            "arrivalCity": "Rome",
            "departureTime": "2025-10-20T14:00:00",
            "arrivalTime": "2025-10-20T16:00:00",
            "price": 150.0,
            "availableSeats": 100
        }
        ```

*   **`PUT /api/flights/{id}`**
    *   **Description**: Update an existing flight's information.
    *   **Access**: `ADMIN`

*   **`DELETE /api/flights/{id}`**
    *   **Description**: Delete a flight.
    *   **Access**: `ADMIN`

--- 

### Hotels

*   **`GET /api/hotels`**
    *   **Description**: Get all available hotels.
    *   **Access**: Public

*   **`GET /api/hotels/search`**
    *   **Description**: Search for hotels by city.
    *   **Query Parameters**: `city` (string).
    *   **Access**: Public

*   **`POST /api/hotels`**
    *   **Description**: Add a new hotel.
    *   **Access**: `ADMIN`
    *   **Request Body**:
        ```json
        {
            "name": "Grand Hotel",
            "city": "Rome",
            "stars": 5,
            "pricePerNight": 250.0,
            "availableRooms": 50
        }
        ```

*   **`PUT /api/hotels/{id}`**
    *   **Description**: Update an existing hotel's information.
    *   **Access**: `ADMIN`

*   **`DELETE /api/hotels/{id}`**
    *   **Description**: Delete a hotel.
    *   **Access**: `ADMIN`

--- 

### Cars

*   **`GET /api/cars`**
    *   **Description**: Get all available rental cars.
    *   **Access**: Public

*   **`GET /api/cars/search`**
    *   **Description**: Search for cars by city.
    *   **Query Parameters**: `city` (string).
    *   **Access**: Public

*   **`POST /api/cars`**
    *   **Description**: Add a new car.
    *   **Access**: `ADMIN`
    *   **Request Body**:
        ```json
        {
            "model": "Model 3",
            "brand": "Tesla",
            "city": "San Francisco",
            "pricePerDay": 80.0,
            "available": true
        }
        ```

*   **`PUT /api/cars/{id}`**
    *   **Description**: Update a car's information.
    *   **Access**: `ADMIN`

*   **`DELETE /api/cars/{id}`**
    *   **Description**: Delete a car.
    *   **Access**: `ADMIN`

--- 

### Travel Packages

*   **`GET /api/packages`**
    *   **Description**: Get all travel packages.
    *   **Access**: Public

*   **`GET /api/packages/{id}`**
    *   **Description**: Get a specific travel package by its ID.
    *   **Access**: Public

*   **`POST /api/packages`**
    *   **Description**: Add a new travel package.
    *   **Access**: `ADMIN`
    *   **Request Body**:
        ```json
        {
            "name": "European Adventure",
            "description": "A 10-day tour of Paris, Rome, and Barcelona.",
            "includedPlaces": ["Paris", "Rome", "Barcelona"],
            "totalCost": 2500.0
        }
        ```

*   **`PUT /api/packages/{id}`**
    *   **Description**: Update a travel package.
    *   **Access**: `ADMIN`

*   **`DELETE /api/packages/{id}`**
    *   **Description**: Delete a travel package.
    *   **Access**: `ADMIN`

--- 

### Bookings

*   **`POST /api/bookings`**
    *   **Description**: Create a new booking for a flight, hotel, car, or package.
    *   **Access**: Authenticated `USER`
    *   **Request Body**:
        ```json
        {
            "bookingType": "FLIGHT",
            "referenceId": 1
        }
        ```

*   **`GET /api/bookings`**
    *   **Description**: Get all bookings for the currently authenticated user.
    *   **Access**: Authenticated `USER`

*   **`GET /api/bookings/{id}`**
    *   **Description**: Get a specific booking by its ID.
    *   **Access**: Authenticated `USER` (and owner of the booking).
