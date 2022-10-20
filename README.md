# TKup ShoppingCart

Technologies: SpringBoot Framework, Database ( MariaDB, Hibernate, ORM)

REST API: Postman

## Models:

1. User
2. Role
3. ProductDetails
4. Categories
5. Cart


![tkup_diagram](https://user-images.githubusercontent.com/89743843/196831442-32924062-0406-4a16-b43b-55eff2473d73.png)

Project detail explanation: https://docs.google.com/document/d/1cCC6olKz8DVCfwyjTzOCoqSUzJIH00id/edit

Each model has their own Repository, Service, ServiceImpl

Controller connect with views using thymeleaf and RestController connect with REST API

How to run the application: 

Can run inside SpringBoot IDE 

Also the application.properties file contains sql initialize that allows runner to insert some given dummy data

