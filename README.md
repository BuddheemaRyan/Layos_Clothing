# Layos Clothing Shop

A full-stack e-commerce clothing store application built with **Spring Boot** (backend) and **HTML/Bootstrap/JavaScript** (frontend).

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Frontend](#frontend)

---

## Overview

Layos Clothing Shop is a product catalogue application that lets you manage and display clothing products (shoes, shirts, pants, watches, etc.) through a REST API backed by a MySQL database, with a responsive frontend that renders product cards dynamically.

---

## Tech Stack

| Layer     | Technology                        |
|-----------|-----------------------------------|
| Backend   | Java 23, Spring Boot 4.0.0-RC2    |
| Database  | MySQL (mysql-connector-j 9.4.0)   |
| Utilities | Lombok 1.18.40                    |
| Frontend  | HTML5, Bootstrap 5.3.8, Vanilla JS |
| Build     | Apache Maven                      |

---

## Project Structure

```
Layos_Clothing/
├── assets/
│   ├── css/
│   │   └── style.css          # Custom frontend styles
│   └── js/
│       └── app.js             # Product fetch & render logic
├── src/
│   └── main/java/edu/icet/ecom/
│       ├── Main.java                        # Spring Boot entry point
│       ├── controller/
│       │   └── ProductsController.java      # REST controller
│       ├── service/
│       │   └── ProductService.java          # Business logic
│       ├── repository/
│       │   └── ProductRepository.java       # Data access layer
│       ├── db/
│       │   └── DBConnection.java            # Database connection
│       └── model/dto/
│           └── Product.java                 # Product DTO
├── index.html                 # Frontend entry point
└── pom.xml                    # Maven build configuration
```

---

## Prerequisites

- **Java 23** or higher
- **Maven 3.8+**
- **MySQL 8+** running locally

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/BuddheemaRyan/Layos_Clothing.git
cd Layos_Clothing
```

### 2. Set up the database

Create a MySQL database and configure your connection details in `src/main/resources/application.properties` (create this file if it doesn't exist):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/layos_clothing
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Create the `product` table:

```sql
CREATE DATABASE layos_clothing;
USE layos_clothing;

CREATE TABLE product (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    category VARCHAR(100),
    price    DECIMAL(10, 2) NOT NULL,
    stock    INT            NOT NULL DEFAULT 0,
    image    VARCHAR(500)
);
```

### 3. Build and run the backend

```bash
mvn spring-boot:run
```

The server will start at `http://localhost:8080`.

### 4. Open the frontend

Open `index.html` directly in your browser. It will fetch products from the running Spring Boot backend at `http://localhost:8080/product/getAll` and display them as cards.

---

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint              | Description             | Body            |
|--------|-----------------------|-------------------------|-----------------|
| GET    | `/product/getAll`     | Retrieve all products   | —               |
| GET    | `/get/product/{id}`   | Retrieve product by ID  | —               |
| POST   | `/add/product`        | Add a new product       | `Product` JSON  |
| POST   | `/update/product`     | Update existing product | `Product` JSON  |
| GET    | `/delete/product/{id}`| Delete product by ID    | —               |

### Product JSON schema

```json
{
  "id": 1,
  "name": "Classic White Tee",
  "category": "Shirts",
  "price": 29.99,
  "stock": 50,
  "image": "https://example.com/images/white-tee.jpg"
}
```

---

## Frontend

The frontend is a single-page HTML application (`index.html`) that:

- Displays a **responsive navbar** with categories: Home, Shoes, Shirts, Pants, Watch.
- Fetches all products from the backend API on load.
- Renders each product as a **Bootstrap card** showing the image, name, category, price, and stock level.
  - Stock > 10 → shown in green
  - Stock 1–10 → shown in yellow ("Only X left!")
  - Stock 0 → shown in grey ("Out of stock")
