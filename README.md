# file-upload

Implements a Restful API in spring-boot. 
The API uploads a file with 2 meta-data fields file name and file size which are persisted in persistent store (In memory DB - H2). The file is stored in a /Temp folder on the file system.
The project includes 1 unit test and 1 Integration test. Some minimal Exceptional handling is implemented. There is no front end however the API can be tested through Postman and of course the integration test.

Java 8 is used

H2 database is used