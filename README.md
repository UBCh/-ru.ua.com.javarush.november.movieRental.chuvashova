## exercise

-there is a database MySQL  ["movie"]().

- map entities to existing tables
- add functionality to create a new customer
- add a transactional method that describes the "buyer went and returned a previously rented movie" event
- add a transactional method that describes the event “The customer went to the store and rented a movie. In doing so,
  he made payment to the seller. The film must be available for rent.
- add a transactional method that describes the event "a new movie was shot and it became available for rent"

## List of required installed software

* **IntelliJ IDEA Ultimate**
* **Java 18**
* **Workbench**  (for any other service for mySql administration)

## used

- MAVEN
- hibernate
- mySql
- Lombok
- p6spy

## implemented

- maven project created, dependencies included
- deployed database locally end Connected in Idea as datasource
  -all necessary entity classes have been created and mapped to movie schema tables.
- created interface EntityRepository<T> and all its necessary implementations
- created services to interact with each implementation interface EntityRepository<T>
- implemented functionality to create a new customer
- implemented functionality for adding a new movie
- implemented the functionality of returning a previously rented film to the store
- implemented the functionality of creating a new event "to rent a movie"

## implementation features

- the main class implements auxiliary functionality that simulates receiving data from the user

## запуск на локальной машине

- запустить Docker
- стартовать контейнер mySQL
- стартовать контейнер Redis
- RUN

## отчет

- результат тестирования выводится в консоль.
- в виде (пример)
  Redis:    173 ms
  MySQL:    735 ms
  H2DB:    638 ms


