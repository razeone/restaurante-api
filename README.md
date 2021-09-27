# restaurante-api

[![Build Status](https://app.travis-ci.com/razeone/restaurante-api.svg?branch=main)](https://app.travis-ci.com/razeone/restaurante-api)

This is an example repository for teaching purposes. Be aware that you can demo it without changing anything, you just need to run the application and play with the endpoints, if you're planning to persist and probably use this is a more controlled environment, you migh want to look at the database configuration inside the `src/main/resources/application.propperties` file.

## Test and Build

```bash
./mvnw package
```

## Run locally

```bash
./mvnw spring-boot:run
```

## Available endpoints

```bash
# Platillo
POST /api/platillo # Create a platillo
GET /api/platillo/{IdPlatillo} # Get a single platillo
PUT /api/platillo/{IdPlatillo} # Update a platillo
DELETE /api/platillo/{IdPlatillo} # Delete a platillo
GET /api/platillo # Get all platillos
# Orden
POST /api/orden # Create an orden
GET /api/orden/{IdOrden} # Get a single orden
PUT /api/orden/{IdOrden} # Update an orden
DELETE /api/orden/{IdOrden} # Delete an orden
GET /api/orden # Get all ordenes
```
