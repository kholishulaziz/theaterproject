## Theater Project
Application for manage printing system.

Service 
https://github.com/kholishulaziz/theaterproject

Channel-Mobile
https://github.com/kholishulaziz/theaterprint-mobile

Channel-Web 
https://github.com/kholishulaziz/theaterprint-web

@theaterproject
2018

## Tools and Technology used
* Java 1.8
* Apache Maven
* Spring Boot
* RESTfull Web Service
* MySQL
* OAuth2
* Android
* React

**Starting Service**
```
mvn spring-boot:run
```

**Authorization**
```
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'authorization: Basic dGhlYXRlcjpQQHNzdzByZA==' \
  -d 'grant_type=password&username=aziz&password=P@ssw0rd'
```

**Create HTTP Request**
```
curl -X GET \
  http://localhost:8080/api/tp-trx/last \
  -H 'authorization: Bearer {access_token}'
```