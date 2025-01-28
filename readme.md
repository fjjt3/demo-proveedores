# Providers Microservice Demo

This is a simple implementation for a Restful Microservice based on Spring Boot to manage clients and providers
relationship.

## Features
- Simple Restful endpoint to retrieve client´s providers given a Client´s id 
- H2 in-memory database with pre-loading data 
- Spring Boot, Sprint Data.

## Tech Stack
- ***Spring Boot***: Framework for building the application.
- ***H2 Database***: In-memory database for development.
- ***Maven***: Build and dependency management tool.
- ***Java***: (version: 17) - Programming language.
- ***JUnit 5***: Testing framework.
- ***Mockito***: Mocking Tool.

## Getting Started

### Prerequisites
- Java 17 or later installed. [Download Java here.](https://adoptopenjdk.net/)
- Maven installed. [Download Maven here.](https://maven.apache.org/download.cgi)

Verify installations:
```bash
java -version
mvn -version
```

### Installation

Clone the repository
```bash
  git clone https://github.com/fjjt3/demo-proveedores.git
  cd demo-proveedores
  ```
Build the application
```bash
mvn clean package
```

Start the application

```bash
java -jar target/demo-proveedores-0.0.1-SNAPSHOT.jar
mvn spring-boot:run
```

## Running the Application

- Default URL: [http://localhost:8080](http://localhost:8080)
- Swagger Console: http://localhost:8080/swagger-ui/index.html
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - Username: `sa`
    - Password: (leave blank)


### Configuration

#### Application Properties
The application can be configured using the `application.properties` file.

#### Example `application.properties`:
```properties
# JPA Connectivity
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.initialization-mode=always
spring.jpa.defer-datasource-initialization=true

# Enables H2 console
spring.h2.console.enabled=true
spring.datasource.username=sa
spring.datasource.password=

# Ensures the schema is generated
spring.jpa.hibernate.ddl-auto=create-drop

# Ensures `data.sql` is executed
spring.sql.init.mode=always

# Swagger Enabled
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
```

##  **API Endpoints**~~~~

```markdown
## API Endpoints
### Base URL: `http://localhost:8080`

| HTTP Method | Endpoint                  | Description                      |
|-------------|---------------------------|----------------------------------|
| GET         | `/proveedores/{id}`       | Get providers by client ID.      |
```

## Testing

Unit tests are written using JUnit and Spring Boot Test, using Mockito Framework to mock
dependencies.
Run all tests with:

```bash
mvn test
```

## License
This project is licensed under the [MIT License](LICENSE).

## Contact

GitHub: [@fjjt3](https://github.com/fjjt3) - Feel free to reach out!