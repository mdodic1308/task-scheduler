# Scheduled tasks
Web app for executing arbitrary groovy scripts.

It contains three parts:
1. Angular based client app
2. Backend Spring boot based REST API consumed by client app
3. Database for storing the tasks. For simplicity, H2 in-memory db is used (as part of Spring boot app)

## Instructions for local running
-[Spring Boot REST API](scheduler-app/README.md)  
-[Angular client](scheduler-client/README.md)
