# Restaurant project

Backend project (API) for an order delivery application.

This application along with delivery app can be used to simulate an order delivery system.
This application is using h2 db which is further shared with delivery system app.
Hence , combination of restaurant and delivery system should be used for full functionality.
## Model entities


`Item` - the actual items that can be ordered by customers

`Order` - set of items ordered by a customer from a restaurant

`DeliveryPerson` - person delivering the order

## Setup & Run

- `clone`
- `mvn spring-boot:run`
- go to `http://localhost:8080/swagger-ui.html#/` to see the available endpoints

## API Docs

Available at: `http://localhost:8080/swagger-ui.html#/`

## Test endpoints with Postman

Test this application endpoints with Postman:

- Start it and import `restaurant.postman_collection.json` which is a collection of example requests.

## Persistence layer

For this project I used embedded [H2 Database]. Since I am also using an ORM solution (Hibernate) it could be switched to another database solution with no major issues.


