# Petfinder API

[Petfinder](https://www.petfinder.com/developers/v2/docs/) is service that provides free API for helping pets find homes.

# Task

## Fetching dogs

Using Spring MVC integrate with Petfinder API. Provide application that will authenticate itself and download information about adoptable dogs in given city.

Here is an example of fetching first 20 dogs from Jersey City.

```
GET /dogs/MA/Andover?size=2&page=3

{
    "pagination": {
        "content": [
            {
                "id": 47831832,
                "name": "May copy #3",
                "breed": "Mixed Breed",
                "age": "Baby",
                "gender": "Female"
            },
            {
                "id": 47831833,
                "name": "May copy #8",
                "breed": "Mixed Breed",
                "age": "Baby",
                "gender": "Female"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": true,
                "unsorted": false,
                "empty": false
            },
            "pageNumber": 3,
            "pageSize": 2,
            "offset": 6,
            "unpaged": false,
            "paged": true
        },
        "totalPages": 532,
        "totalElements": 1063,
        "last": false,
        "first": false,
        "number": 3,
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "numberOfElements": 2,
        "size": 2,
        "empty": false
    },
    "_links": {
        "prev": {
            "href": "http://localhost:8080/dogs/MA/Andover?size=2&page=2"
        },
        "self": {
            "href": "http://localhost:8080/dogs/MA/Andover?size=2&page=3"
        },
        "next": {
            "href": "http://localhost:8080/dogs/MA/Andover?size=2&page=4"
        }
    }
}
```

## User authentication

Your application should be authenticated with basic HTTP authentication. 

Provide user with following credentials:
- login: `doglover`
- password: `hardpassword1234`
