# Petfinder API

[Petfinder](https://www.petfinder.com/developers/v2/docs/) is service that provides free API for helping pets find homes.

# Task

## Fetching dogs

Using Spring MVC integrate with Petfinder API. Provide application that will authenticate itself and download information about adoptable dogs in given city.

Here is an example of fetching first 20 dogs from Jersey City.

```
GET /dogs/jersey-city?size=20

{
    "content": [
        {
            "id": 120,
            "name": "Spot",
            "breed": "Akita",
            "age": "Young",
            "gender": "Male"
        }
    ],
    "pagination": {
        "totalElements": 1,
        "totalPages": 1,
        "size": 20,
        "number": 0
    }
}
```

## User authentication

Your application should be authenticated with basic HTTP authentication. 

Provide user with following credentials:
- login: `doglover`
- password: `hardpassword1234`
