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
View All: http://localhost:5000/res/api/auth/all
```JSON
 {
        "userId": 12,
        "username": "user",
        "password": "$2a$10$ijjd2c6mPti9P4TQZIOYq.6HcKJll8KCYplg.gyumqIn5OfI6qk1e",
        "title": null,
        "email": "up@gmail.com",
        "roles": [
            {
                "id": 2,
                "name": "role_admin"
            },
            {
                "id": 1,
                "name": "role_user"
            }
        ],
        "createdDate": "2021-04-10T22:09:09.453+00:00",
        "lastUpdated": "2021-04-10T22:09:09.453+00:00",
        "userID": 12
    }
```

Add Project: http://localhost:5000/res/api/auth/project/add
```JSON
{
 "time_created":  "2021-04-06T01:41:19.150+00:00",
  "userId": {
       "userId": 11
  }
   
}
```
Result
```JSON
{
    "projectId": 1,
    "timeCreated": null,
    "userId": {
        "userId": 11,
        "username": "binisha",
        "password": "$2a$10$roFHT1cZeKz41X0o96YhNOJTI8trN4ArGn2K31pYubl2M5NqEzQcq",
        "title": null,
        "email": "stha@gmail.com",
        "roles": [
            {
                "id": 1,
                "name": "role_user"
            }
        ],
        "createdDate": "2021-04-10T21:16:12.778+00:00",
        "lastUpdated": "2021-04-10T21:16:12.778+00:00",
        "userID": 11
    }
}
```

Add Resource: http://localhost:5000/res/api/auth/resource/add
```JSON
```
Add Project Column:
```JSON
{
    "projectId":{
       "projectId":1
    },
    "column_name": "General Conditions",
    "type": "FORMULA",
    "formula_text": "test"
}
```
Result
```JSON
{
    "columnId": 2,
    "projectId": {
        "projectId": 1,
        "timeCreated": null,
        "userId": {
            "userId": 11,
            "username": "binisha",
            "password": "$2a$10$roFHT1cZeKz41X0o96YhNOJTI8trN4ArGn2K31pYubl2M5NqEzQcq",
            "title": null,
            "email": "stha@gmail.com",
            "roles": [
                {
                    "id": 1,
                    "name": "role_user"
                }
            ],
            "createdDate": "2021-04-10T21:16:12.778+00:00",
            "lastUpdated": "2021-04-10T21:16:12.778+00:00",
            "userID": 11
        }
    },
    "columnName": null,
    "typeEnum": null,
    "formulaText": null,
    "project": {
        "projectId": 1,
        "timeCreated": null,
        "userId": {
            "userId": 11,
            "username": "binisha",
            "password": "$2a$10$roFHT1cZeKz41X0o96YhNOJTI8trN4ArGn2K31pYubl2M5NqEzQcq",
            "title": null,
            "email": "stha@gmail.com",
            "roles": [
                {
                    "id": 1,
                    "name": "role_user"
                }
            ],
            "createdDate": "2021-04-10T21:16:12.778+00:00",
            "lastUpdated": "2021-04-10T21:16:12.778+00:00",
            "userID": 11
        }
    }
}
```


Add Resources into Project: http://localhost:5000/res/api/auth/projectres/add
```JSON
{
"resourceID": {
    "resourceId": 1
},
"projectID": 
{
    "projectId": 1
}
}
```
```JSON
{
    "recordId": 3,
    "dateCreated": "2021-04-12T01:42:37.590+00:00",
    "projectId": {
        "projectId": 1,
        "timeCreated": null,
        "userId": null
    },
    "resourceId": {
        "resourceId": 1,
        "timeCreated": null,
        "lastUpdated": null,
        "resourceID": 1
    },
    "projectID": {
        "projectId": 1,
        "timeCreated": null,
        "userId": null
    },
    "resourceID": {
        "resourceId": 1,
        "timeCreated": null,
        "lastUpdated": null,
        "resourceID": 1
    }
}
```

Add resourceDetails: http://localhost:5000/res/api/auth/details/add

```JSOn
{
"columnValue": "General Conditions",
"resourceId": {
    "resourceId": 1
},
"columnId": 
{
    "columnId": 1
}
}
```
Result
```JSON
{
    "recordId": 4,
    "timeCreated": null,
    "lastUpdated": null,
    "resourceId": {
        "resourceId": 1,
        "timeCreated": "2021-04-11T01:28:53.722+00:00",
        "lastUpdated": "2021-04-11T01:28:53.722+00:00",
        "resourceID": 1
    },
    "columnValue": "General Conditions",
    "columnId": {
        "columnId": 1,
        "projectId": {
            "projectId": 1,
            "timeCreated": null,
            "userId": {
                "userId": 11,
                "username": "binisha",
                "password": "$2a$10$roFHT1cZeKz41X0o96YhNOJTI8trN4ArGn2K31pYubl2M5NqEzQcq",
                "title": null,
                "email": "stha@gmail.com",
                "roles": [
                    {
                        "id": 1,
                        "name": "role_user"
                    }
                ],
                "createdDate": "2021-04-10T21:16:12.778+00:00",
                "lastUpdated": "2021-04-10T21:16:12.778+00:00",
                "userID": 11
            }
        },
        "columnName": null,
        "typeEnum": null,
        "formulaText": null,
        "project": {
            "projectId": 1,
            "timeCreated": null,
            "userId": {
                "userId": 11,
                "username": "binisha",
                "password": "$2a$10$roFHT1cZeKz41X0o96YhNOJTI8trN4ArGn2K31pYubl2M5NqEzQcq",
                "title": null,
                "email": "stha@gmail.com",
                "roles": [
                    {
                        "id": 1,
                        "name": "role_user"
                    }
                ],
                "createdDate": "2021-04-10T21:16:12.778+00:00",
                "lastUpdated": "2021-04-10T21:16:12.778+00:00",
                "userID": 11
            }
        }
    },
    "resource": {
        "resourceId": 1,
        "timeCreated": "2021-04-11T01:28:53.722+00:00",
        "lastUpdated": "2021-04-11T01:28:53.722+00:00",
        "resourceID": 1
    }
}
```