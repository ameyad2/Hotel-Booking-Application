
# Hotel Booking Application

![Hotel Booking Application](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/HomePageInfo.PNG?raw=true)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technology Stack](#technology-stack)
- [API Documentation](#api-documentation)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The Hotel Booking Application is a full-stack Java-based web application designed to streamline hotel booking processes. The backend is powered by Spring Boot and Hibernate, providing a robust and scalable solution for managing hotel reservations. The application also implements JWT authentication to secure user sessions.

## Features
- **User Authentication**: Secure login and registration with JWT.
- **Hotel Management**: Add, update, delete, and view hotel details.
- **Booking Management**: Users can book rooms, view their bookings, and cancel if needed.
- **Role-Based Access**: Admin and user roles with specific privileges.


## Installation
### Prerequisites
- Java 8+
- Maven
- MySQL
- JWT
- Spring Security
- RESTful APIs
- Hibernate ORM

### Backend Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/ameyad2/Hotel-Booking-Application.git
    cd Hotel-Booking-Application
    ```
2. Set up the MySQL database:
    ```sql
    CREATE DATABASE hotel_booking;
    ```
3. Update `application.properties` with your database and Redis configurations.
4. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend Setup
To set up the front end of the Hotel Booking Application, follow these steps:

1. **Set up a Vite React environment**:
   ```bash
   npm create vite@latest
   ```

2. **Install Tailwind CSS and necessary plugins**:
   ```bash
   npm install -D tailwindcss postcss autoprefixer
   npx tailwindcss init -p
   ```

3. **Install additional dependencies**:
   - Install Axios:
     ```bash
     npm i axios
     ```
   - Install jwt-decode:
     ```bash
     npm i jwt-decode
     ```

## Usage
- Access the application at `http://localhost:8080`.
- Register or log in to start booking hotels.
- Admins can manage hotels and view all bookings.

## Technology Stack
- **Backend**: Java Spring Boot, Hibernate, JWT, MySQL, Spring MVC, Spring Web, RESTful APIs
- **Frontend**: React.js, vite
- **Security**: Spring Security with JWT

## API Documentation

The following section details the API endpoints available in the Hotel Booking Application. The API documentation is based on the Postman collection provided in this repository.

### Authentication

#### Register a New User
- **Endpoint**: `POST /auth/register`
- **Description**: Registers a new user in the system.
- **Request Body**:
    ```json
    {
        "username": "exampleuser",
        "password": "examplepassword"
    }
    ```
- **Response**:
    - `201 Created`: Returns success message with user details.

#### Authenticate User (Login)
- **Endpoint**: `POST /auth/login`
- **Description**: Authenticates the user and returns a JWT token.
- **Request Body**:
    ```json
    {
        "username": "exampleuser",
        "password": "examplepassword"
    }
    ```
- **Response**:
    - `200 OK`: Returns the JWT token.

### Hotels

#### Get All Hotels
- **Endpoint**: `GET /hotels`
- **Description**: Retrieves a list of all available hotels.
- **Response**:
    - `200 OK`: Returns an array of hotel objects.

#### Add a New Hotel
- **Endpoint**: `POST /hotels`
- **Description**: Adds a new hotel to the database. (Admin only)
- **Request Body**:
    ```json
    {
        "name": "Hotel California",
        "location": "Los Angeles",
        "roomsAvailable": 15,
        "pricePerNight": 200
    }
    ```
- **Response**:
    - `201 Created`: Returns the created hotel object.

#### Update Hotel Details
- **Endpoint**: `PUT /hotels/{id}`
- **Description**: Updates the details of an existing hotel. (Admin only)
- **Request Body**:
    ```json
    {
        "name": "Hotel California",
        "location": "Los Angeles",
        "roomsAvailable": 10,
        "pricePerNight": 250
    }
    ```
- **Response**:
    - `200 OK`: Returns the updated hotel object.

#### Delete a Hotel
- **Endpoint**: `DELETE /hotels/{id}`
- **Description**: Deletes a hotel from the database. (Admin only)
- **Response**:
    - `204 No Content`: Hotel successfully deleted.

### Bookings

#### Book a Room
- **Endpoint**: `POST /bookings`
- **Description**: Books a room at a selected hotel.
- **Request Body**:
    ```json
    {
        "hotelId": 1,
        "userId": 1,
        "checkInDate": "2024-09-01",
        "checkOutDate": "2024-09-05"
    }
    ```
- **Response**:
    - `201 Created`: Returns the booking confirmation details.

#### Get User Bookings
- **Endpoint**: `GET /bookings`
- **Description**: Retrieves a list of bookings made by the user.
- **Response**:
    - `200 OK`: Returns an array of booking objects.

#### Cancel a Booking
- **Endpoint**: `DELETE /bookings/{id}`
- **Description**: Cancels a booking.
- **Response**:
    - `204 No Content`: Booking successfully canceled.

## Screenshots

### Browse All Rooms View
![Browse All Rooms](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/BrowseAllRooms.PNG?raw=true)

### Booking Information
![Booking Information](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/BookingInformation.PNG?raw=true)

### Existing Rooms Admin View
![Existing Rooms Admin View](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/AdminExistingBookings.PNG?raw=true)

### Filter By Booking Date View
![Filter By Booking Date](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/FilterBookingsByDate.PNG?raw=true)

### Browse Rooms by Checkin Date View
![Browse Rooms by Checkin Date View](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/BrowseRoomByCheckInDateHomePage.PNG?raw=true)

### Reserve Room View
![Reserve Room](https://github.com/ameyad2/Hotel-Booking-Application/blob/master/images-demo/ReserveRoom.PNG?raw=true)


## Contributing
Feel free to fork this repository, make feature branches, and create pull requests. For major changes, please open an issue to discuss what you would like to change.

## 🚀 About Me

## About Me

I am a full-stack developer with a strong focus on backend development. With over 2.5 years of experience in the industry, I have honed my skills in a wide range of backend technologies and frameworks. My expertise includes:

- **Spring Boot**: Building scalable and efficient backend applications.
- **Java**: Writing robust and maintainable code.
- **JPA-Hibernate**: Managing database interactions with ease.
- **Kafka**: Implementing reliable messaging and streaming systems.
- **Backend Development Architecture**: Designing and implementing reliable and scalable backend systems.
- **REST and SOAP Requests**: Developing and consuming APIs with precision.
- **Data Structures and Algorithms**: Solving complex problems with optimized solutions.
- **MySQL & IBM DB2**: Managing and querying relational databases effectively.
- **Additional Backend Technologies**: Experience with tools and platforms such as Docker, Kubernetes, Microservices architecture, and CI/CD pipelines.

My passion for backend development drives me to continuously learn and improve, ensuring that I stay updated with the latest trends and technologies in the field.
