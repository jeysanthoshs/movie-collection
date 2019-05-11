# Movie Collection API

Movie collection API is a backend service that provides information about a private movie collection. This API provides the following operations to the client.

```
GET /api/timeOfDay - Returns the time of the day
GET /api/movie/list - Returns all the movies in the collection
GET /api/movie/{movie_id} - returns the movie with the specific ID
GET /api/movie?name={name} - returns all the movies matching the name
POST /api/movie - creates a new movie in the movie collection
PUT /api/movie - Updates the movie data in the datastore
DELETE /api/movie/{movie_id} - removes the movie from the collection
```

## Movie Object JSON

All request and response for this API to retrieve, create and update the movie collection is done using the following JSON format:
```
{
        "id": 1,
        "name": "test",
        "genere": "test",
        "releaseYear": 1000,
        "rating": 3.2
}
```
Id - Autogenerated primary key
Name - Name of the movie
Genere - Movie Genere
ReleaseYear - The year in which the movie was released
rating - Overall rating of the movie

### Instructions to execute

//TODO

```
//TODO
```


## Built With

* Java 8
* Spring Boot, Spring Web, Spring JPA
* Gradle
