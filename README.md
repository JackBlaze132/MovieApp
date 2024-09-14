# Movie API

Welcome to the Movie API!

This API provides access to a vast collection of movie data, including titles, genres, directors, and more.

## Endpoints

### GET /movies

Returns a list of all movies in the database.

**Example response:**
```json
[
    {
        "id": 1,
        "name": "Shrek",
        "category": null,
        "year": 2001,
        "director": "Andrew Anderson",
        "duration": 90,
        "rating": 4.5
    },
    {
        "id": 2,
        "name": "El resplandor",
        "category": null,
        "year": 1980,
        "director": "Stanly Kubric",
        "duration": 146,
        "rating": 4.0
    }
]
```
### GET /movies/:id
Returns a single movie by ID.

**Parameters:**
- `id`: The ID of the movie to retrieve.

**Example response:**
```json
{
  "id": 1,
  "name": "Shrek",
  "category": null,
  "year": 2001,
  "director": "Andrew Anderson",
  "duration": 90,
  "rating": 4.5
}
```
### POST /movies
Creates a new movie.

**Parameters:**
- `name`: The title of the movie.
- `category`: The genre of the movie.
- `year`: The year of the movie.
- `director`: The director of the movie.
- `duration`: The duration of the movie in minutes.
- `rating`: Calificaiton of the movie.

**Example request body:**
```json
{
  "name": "Shrek",
  "category": null,
  "year": 2001,
  "director": "Andrew Anderson",
  "duration": 90,
  "rating": 4.5
}
```
### PUT /movies/:id
Updates an existing movie.

**Parameters:**
- `id`: The ID of the movie to update.
- `name`: The title of the movie.
- `category`: The genre of the movie.
- `year`: The year of the movie.
- `director`: The director of the movie.
- `duration`: The duration of the movie in minutes.
- `rating`: Calificaiton of the movie.

**Example request body:**
```json
{
  "id": "1"
  "name": "Shrek",
  "category": "animation", <-----changed
  "year": 2001,
  "director": "Vicky Jenson", <-----changed
  "duration": 90,
  "rating": 4.5
}
```
### DELETE /movies/:id
Deletes a movie.

**Parameters:**
- `id`: The ID of the movie to delete.
  
