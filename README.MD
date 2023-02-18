# Spring Boot Todo

A simple spring boot todo backend application that 
enables you to manage your todos

## Testing

Get the project on your pc:
```bash
  git clone https://github.com/jazzybruno/spring-boot-todo.git
```

Run the program to install maven
```bash
 mvn install 
```

Add your database in the application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/{your_database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}
```

Then after installation of packages and adding your data 
run the application and go to :
```bash
http://localhost:8000/swagger-ui.html
```

you can edit the port if you wish : 
go to applcation.properties and add the port configuration
```bash
server.port = {the_port_you_choose}
```

You should get a page like this:
![Screenshot  2023-02-18 130829.png](src%2Fmain%2Fresources%2Fimages%2FScreenshot%202023-02-18%20130829.png)