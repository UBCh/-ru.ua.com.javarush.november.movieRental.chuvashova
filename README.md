## exercise

- there is a database
  MySQL  ["movie"](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/movie.png).
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
- all necessary entity classes have been created and mapped to movie schema tables.
- created interface EntityRepository<T> and all its necessary implementations
- created services to interact with each implementation interface EntityRepository<T>
- implemented functionality
  to [create a new customer](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/java/com/javarush/BuyerRegistration.java)
- implemented functionality
  for [adding a new movie](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/java/com/javarush/MovieRegistration.java)
- implemented the functionality
  of [returning a previously rented film](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/java/com/javarush/MovieReturn.java)
  to the store
- implemented the functionality of creating a new
  event ["to rent a movie"](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/java/com/javarush/RentMovie.java)

## implementation features

the [creatorDTO class](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/java/com/javarush/creatorDTO.java)
implements auxiliary functionality that simulates receiving data from the user

## run on local machine

- deployed
  [database locally](https://github.com/UBCh/-ru.ua.com.javarush.november.movieRental.chuvashova/blob/total/src/main/resources/dump-hibernate-2.sql)
  end Connected in Idea as datasource
- enter the necessary data in the creatorData class in order to avoid duplication of data saved to the database
- RUN

## identified errors in the database architecture

- absence of foreign key in the film_text table on the film_id field of the film table
- the title and description columns are duplicated in the film and text_film tables
- in film table the title column is set to varchar(128), which does not match the characteristic of the title column in
  the text_film varchar(255) table
- the appointment of the staff_id column in the store table is not clear, foreign key in the store table on the staff_id
  field of the staff table on the manager_staff_id field
  


