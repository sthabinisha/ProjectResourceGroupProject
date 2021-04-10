* [RESTful URLs](#restful-urls)

## RESTful URLs

User API

POST: http://localhost:5000/res/api/auth/signup


```JSON
{

    "username": "binisha",
    
    "email": "stha@gmail.com",
    
    "password": "shrestha",
    
    "roles": [
    
        "role_user", "role_admin"
    ]
}
```

POST: http://localhost:5000/res/api/auth/signin
```JSON
{
    "usernameOrEmail": "binisha",
     "password": "shrestha"
   
}
```
Result:
```JSON
{
    
     "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMCIsImlhdCI6MTYxODA4MjgxOCwiZXhwIjoxNjE4MTcwMjE4fQ.GaUJvrYKFNtw2vWO6V8deODAnH7IMP0Evy15LZdcBnCU65EyGbABOymLtRHzmZRvU2d57w7fwW-jcpeUlHCNKg",
     "tokenType": "Bearer"
    
   
}
```