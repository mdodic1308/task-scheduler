# Spring boot based REST API for managing of scheduled tasks

## Instructions for local running
./gradlew bootRun    - for Linux  
gradlew.bat bootRun   - for Windows  

For overriding default configuration, you should pass the command line arguments in this format:  
--args='--name1=value1 --name2=value2'  
, where 'name1' is the name and 'value1' is the value of the argument.  

For example, this command (Linux) will start application on the port 8081, with thread pool with size of 2:
./gradlew bootRun --args='--server.port=8085 --thread-pool.size=2'

## API consuming
API supports CRUD operations using HTTP methods:
- POST resourceUrl/ (create)
- GET resourceUrl/ (read all)
- GET resourceUrl/id (read by ID)
- PUT resourceUrl/id (update)
- DELETE resourceUrl/id (delete) 
, where resourceUrl is url address of resource (eg http://localhost:8080/api/scheduledTasks)

example of POST JSON body:
{
    "name": "test",
    "recurrency": "*/10 * * * * *",
    "code": "int fib(int n)\n{ n < 2 ? 1 : fib(n-1) + fib(n-2)} \nsleep(3000)\nprintln fib(10)"
}