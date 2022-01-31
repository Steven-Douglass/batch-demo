# Spring Batch Item Generator
This project consists of three parts
- A Spring Boot backend which includes Spring Batch data processing and an API
- An Angular front end to call the backend API methods and display our data
- **A local instance of PostgreSQL which is not included in this project**
  - Attempting to clone and run this repository will fail unless a PostgreSQL or other SQL database instance is configured. The batch-demo-be application.properties file must be updated to connect to a PostgreSQL or other SQL database instance. When the application starts the batch job runs once and all required database tables will be created automatically.

## Spring Boot Backend
Contents exist within the batch-demo-be folder
The Spring Boot Backend can be deployed locally with the following commands

```
cd /batch-demo-be

./mvnw clean install -DskipTests

cd target

java -jar batch-demo-be-0.0.1-SNAPSHOT.jar
```

The batch job runs when the application starts and can be triggered to run again via an API Endpoint.

### API Endpoints
- localhost:8080/api/runBatchJob
  - Trigger the batch job to run
- localhost:8080/api/getExportData
  - Return the contents of the export_data table in JSON format
- localhost:8080/api/deleteAll
  - Delete the contents of the export_data table

## Angular Frontend
Contents exist within the batch-demo-fe folder

The Angular Frontend depends upon the [Angular CLI](https://angular.io/guide/setup-local) which can be installed with the following command
```
npm install -g @angular/cli
```

The Angular Frontend can be deployed locally with the following commands
```
npm install
ng serve
```

The Angular Frontend consists of an Angular Material UI Table with sorting, filtering, and pagination. The buttons 'Add more data' and 'Delete all data' hit the Spring Boot Backend APIs and refresh the table automatically.

![Screenshot](./ScreenshotFE.png)