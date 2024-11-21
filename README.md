NimapProductCategoryCRUD
Nimap Infotech - Category & Product Management API This is a Spring Boot project demonstrating a RESTful API for managing categories and products with MySQL database integration. It supports CRUD operations for both categories and products and features server-side pagination for efficient data handling. The application also implements a one-to-many relationship between categories and products.

Features: 1.CRUD Operations for Categories and Products 2.One-to-Many Relationship between Categories and Products 3.Server-Side Pagination for efficient data handling 4.REST APIs for managing Categories and Products 5.Annotation-based Configuration (No XML) 6.JPA & Hibernate for database interaction

Prerequisites: Before running the project, ensure you have the following installed: Java 17 or higher MySQL 5 or above (If MySQL 5 is unavailable, modify the dependency in pom.xml accordingly) Postman or any API testing tool.

How to Run the Project

Clone the Repository git clone https://github.com/Madhuri-bangar/NimapProductCategoryCRUD.git cd nimap-infotech-java-machine-test

Configure Database Ensure your database is set up correctly. Update the application.properties file with your MySQL database credentials: spring.application.name=category_product server.port=8080

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.url=jdbc:mysql://localhost:3306/nimap spring.datasource.username=root spring.datasource.password=***** spring.jpa.hibernate.ddl-auto=update spring.jpa.properties.dialect.hibernate = org.hibernate.dialect.MySQL8Dialect

Run the Application Using Spring Tool Suite (STS)/Eclipse: Right-click on the project → Run As → Spring Boot App/java application.

Test the APIs Use Postman or any API testing tool to test the available API endpoints.
