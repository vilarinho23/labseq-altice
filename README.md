# Labseq Sequence

Web application to calculate values from the Labseq sequence.

## Prerequisites

To run the project, choose one of the following options:

### Option 1: Using Docker (recommended)

- Docker
- Docker Compose

### Option 2: Running Locally (without Docker)

- Java (v21)
- Maven
- Node.js and npm
- Angular CLI (`npm install -g @angular/cli`)


## Execution

### Option 1: With Docker

Inside the project folder, run the following command to build and start the containers:

```bash
docker-compose up --build
```

After everything is up and running, you can interact with the application using one of these options:

- For the Web Application use [http://localhost](http://localhost) in your browser.
- Or for the API use the Swagger UI at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

### Option 2: Running Locally (without Docker)

You’ll need to start both the backend and frontend manually.

1. Start Backend (Quarkus)

```bash
cd backend_quarkus
./mvnw quarkus:dev
```

This will start the backend API at http://localhost:8080

2. Start Frontend (Angular)

```bash
cd frontend_quarkus/labseq-ui
npm install
ng serve
```

This will start the frontend at http://localhost:4200



## Running Tests

To run backend tests, navigate to the `backend_quarkus` folder and execute Maven tests:

```bash
mvn test
```

The tests cover:

- **LabseqResourceTest**: tests the REST API endpoints for valid, invalid, and large input values.

- **LabseqServiceTest**: validates the sequence calculation logic, including base cases, recursion, large inputs, and error handling.
