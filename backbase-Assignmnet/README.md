# Atm Finder

A spring boot project with basic spring security in place. The rest API is exposed by cosuming a  External rest-api. 
The API is consumed by UI built on basic Jquery 

## Different REST End point Exposed in Application

*  list all the ATM without any Filter

`http://localhost:8080/ATMlocations/`

Sample PayLoad will be 

```
{
"list": [
{
"address": {
"street": "Osdorpplein",
"housenumber": "469",
"postalcode": "1068 SZ",
"city": "Amsterdam",
"geoLocation": {
"lat": "52.358823",
"lng": "4.802086"
}
},
"distance": 0,
"type": "ING"
}

```

*  Search ATMS for a given city

Example

```
http://localhost:8080/ATMlocations/search?city=Amsterdam
```
Sample payload will be 

```
{
"list": [
{
"address": {
"street": "Buikslotermeerplein",
"housenumber": "426",
"postalcode": "1025 WP",
"city": "Amsterdam",
"geoLocation": {
"lat": "52.397468",
"lng": "4.94107"
}
},
"distance": 0,
"type": "ING"
}

```
## Overall Architecture 


Utilized spring initializer project to generate the Skeleton

- Added thymeleaf templating engine, with basic spring security starter and spring boot jersey dependencies.
- Configured Basic Security, Resttemplate calls with by-passing ssl for consuming ING web service ( https://www.ing.nl/api/locator/atms/ )
- jQuery and Datatables.js is utilized along with Bootstrap.css for implementing UI elements.

## How is the Architecture Designed  and components are layered ?
![alt text](Sequence-Diagram.jpg)

I have used MVC Pattern with Domain Driven Design Concept

### Application Service:
Spring Rest Controller acts as an Application Service (AtmApplicationService.java)
This exposes 2 rest Api's as explained Above

This will be calling multiple Domain Services depending on the Use case. In our case we have a simple get we call and no orchestration involved. AtmApplicationService will call AtmDomainServices

#### Domain Services:
AtmDomainServiceImpl : This implements business logic  required for the Retrieving the List of ATM method. In this it simply calls Repository which will abstract any call to the DB or External service.


#### Repositories:
AtmDataReposiroty : 
This repository is only responsible ATM Aggregate. This has a clear-cut boundary compare to other Aggregates in the domain model.
This utilizes spring rest-template for consuming the ING ATM locator service. This will abstract the external API call from the domain service. 
#### Other Design Principles Used 
Program for Interface: All the layers depending on the interface and decencies are injected using the Spring Dependency Injection.
SRP : Every Layer has single responsibility and do only one thing.

#### Areas of Improvement if I had time 
Resiliency and Exception Handling 

* Circuit breaker pattern can be while calling the external service this will take care of time out issues and external service not responding 
* Added pagination for Search REST end point so that we can fetch all the ATM Location at one go. This will avoid any huge payload being sent over the network 
* Added proper code for Error handling and do some validation for input parameter
* Implemented Swagger for API documentation

 



#### User interface :

- /home OR / : Home page.
- /login     : Login page. uses in-memory auth : Credentials as:
-                 username : user , password : password
- /atm       : Page that lists all the atm addresses exposed by ING service in form of a Datatable which has all the functions available for sorting , Live search and pagination.

Tools used :
- Maven
- JDK 8
- Spring boot
- Tomcat 7


How to Run ?
maven should be installed.

- clone the repo.
- mvn clean install 
- Deploy to Tomcat 7

OR
- clone the repo.
- mvn clean spring-boot:run
