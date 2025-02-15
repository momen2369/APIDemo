# API Testing with RestAssured

## 📌 Project Overview

This project automates API testing using RestAssured in Java. It ensures robust validation of API endpoints by handling different response scenarios, logging errors, and performing structured assertions.

## 🚀 Tech Stack

- Java 17+

- RestAssured (for API testing)

- TestNG (for test execution)

- Jackson (for JSON serialization/deserialization)

- Maven (for dependency management)

- Lombok (for cleaner POJOs)

- Assertj (for reflection assertions)

## 📂 Project Structure
```bash
APIDemo
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── services         # API service classes
│   │   │   ├── utils            # Utility classes (JSON handling, logging, etc.)
│   │   │   │   ├── models       # POJO classes for request/response payloads
│   │   │   │   ├── readers      # Config and JSON readers
│   │   ├── resources
│   │   │   ├── expectedResponses # JSON files for expected API responses
│   │   │   ├── config.properties # Configuration settings
│   ├── test
│   │   ├── java
│   │   │   ├── usersTests       # API test classes
```

## 📜 Features

✅ BaseService Class - Handles API requests, response logging, and error handling.

✅ POJOs with Lombok - Simplifies request/response serialization.

✅ JSON File Handling - Reads expected responses from external files.

✅ Properties File Handling - Reads data from properties files.

✅ Error Handling - Handles invalid requests, network failures.

## 🛠 Setup & Installation

Clone the repository:
```sh
git clone https://github.com/momen2369/APIDemo.git
```

Install dependencies:

```sh
mvn clean install
```

Run the tests:

```sh
mvn test
```

## 📸 Screenshots
<img width="1333" alt="image" src="https://github.com/user-attachments/assets/89d3c86f-7482-434b-939b-9af7e9aa500e" />

