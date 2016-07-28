# rest-movie-script-sweeper

This is an API which reads scripts from Star Wars movies and extracts information about the movie(like characters, settings, words used), 
and persists the data into a embedded database in-­memory. 

My main goal was to create a complete application, integrating all the frameworks to make a full Web API to deploy into a 
embedded Jetty server. Some technologies used in this application:

- JSE 8
- Spring
- JAX-RS
- Jersey
- JSON
- JPA(Hibernate)
- H2 Database Engine
- Log4j
- JUnit 4
- EasyMock
- Jetty
- Maven

# Building

In order to build the application, you will need:

- Java 8
- Maven 3 or higher
- Internet Connection to download libs from maven central

Just execute the command: mvn clean install

# Running the application

After you've built the project you can run this with a simple maven command:

```bash
mvn jetty:run
```

The application is deployed by default at : http://localhost:8080/sweeper

###### The available rest services are at:

http://localhost:8080/sweeper/rest/movie/{serviceYouWant} (Example: http://localhost:8080/sweeper/rest/movie/settings)

Exposed services:

- url: /script 
	-- HTTP Method: POST 
		-- Accepts: text/plain; charset=utf­8
		
- url: /settings 
	-- HTTP Method: GET 
		-- Accepts: 
		
- url: /settings/{id}
	-- HTTP Method: GET 
		-- Accepts: 
		
- url: /characters 
	-- HTTP Method: GET 
		-- Accepts: 

- url: /characters/{id}
	-- HTTP Method: GET 
		-- Accepts: 

		
###### Database:

The H2 database is automatically deployed by default at: http://localhost:8082/login.do

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:starwarsdb
Login: sa
Password:

Note: Don't worry about scripts, the database is created on deploy and droped on stop. If you want
disable this feature, go to applicationContext.xml file and change the property hibernate.hbm2ddl.auto.


###### Script Movie Test:

You can use a script located in resources folder to test.
I've also created a test class  `ClientRestTest` for fun with it.

