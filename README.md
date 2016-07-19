# Simple mock server / skeleton

### Special thanks for inspiration, idea and support for Maurizio Moscatelli

## Developer 
* Mykola Bova
* e-mail:                 bova.mykola@gmail.com
* Skype:                  mykola_bova
* Blog:                   http://growth4u.blogspot.com/
* LinkedIn:               http://www.linkedin.com/in/mykbova

### Why we need it?
- Quite often some API is not ready as soon as you already need it to be able to implement using it functionality.
- You want to develop faster - local mocks could be faster than calls to "real" API.

### What do you need from this server?
- Full control of returned mocks.
- Additional custom logic can be implemented in controllers when needed.
- To add new points in a quick and easy way.
- Be able to edit mock files quick and easy as often as you need.
- In fact you dont need to restart servers after editing mock files. Just save your updates - thats it!

### Please feel free to
* use onn your projects
* suggest points of improvement

## Build stack
* Java 1.8
* Spring Boot
* Spring Rest
* Apache Commons

## Build mock server locally

```
mvn clean install
```

## Run mock server locally

```
mvn exec:java
```

This will start mock server locally on port 17000

## Design

This is a Spring Boot Rest application.

### Classes
```
mock-server-web\src\main\java\com\bova\services\Application.java
mock-server-web\src\main\resources\application.properties
```

Application entry point.

@ComponentScan define location of packages where Controllers of application will be located (with REST endpoints)

```
mock-server-web\src\main\java\com\bova\services\JettyEmbeddedServletContainerFactory.java
```

Configure error hanlers.

```
mock-server-web\src\main\resources\repositories\example
```

Root folder of "example" repository with mock responses.

You are free to add as muck repositories under "repositories" folder, as you need.

```
mock-server-web\src\main\java\com\bova\services\util\FileUtil.java
```

A first "core" component of server.
Responsible for reading mock files from filesystem.
Used in REST controllers.

```
mock-server-web\src\main\java\com\bova\services\controllers\SimpleErrorController.java
```

Errors handling.

```
mock-server-web\src\main\java\com\bova\services\controllers\AbstractController.java
```

setDefaultContentType

```
mock-server-web\src\main\java\com\bova\services\controllers\example\ExampleController.java
mock-server-web\src\main\java\com\bova\services\controllers\example\LoginController.java
```

Second core part of system - REST Controller.
Customizabe.

You are free to add as much controllers as you need.
But the good idea is to put then in the separate package like "com\bova\services\controllers\example".
You are free to add as much packages as much dirrerent APIs you want to mock by your server.

## Examples of endpoints

### 1. Return a json, using parameter in url 

json
```
{
    "f1": 333,
    "f2": "aaaa",
    "f3": "12345",
    "f4": "USD !",
    "f5": "Test",
    "f6": 11.44,
    "f7": false
}
```

url
```
http://localhost:17000/example/account/11
```

path of mock json on filesystem
```
mock-server-web\src\main\resources\repositories\example\account\11\account
```

### 2. Return a json with fixed url

json
```
[
    {
        "id": 1,
        "description": "type 1"
    },
    {
        "id": 2,
        "description": "type 2"
    }
]

```

url
```
http://localhost:17000/example/account/types
```

path of mock json on filesystem
```
mock-server-web\src\main\resources\repositories\example\account\types
```

### 3. Return a pdf file

url
```
http://localhost:17000/example/11/reports/2014-10-06
```

path of mock json on filesystem
```
mock-server-web\src\main\resources\repositories\example\profiles\report.pdf
```

### 4. Return a cvs file

url
```
http://localhost:17000/example/reports2
```

path of mock json on filesystem
```
mock-server-web\src\main\resources\repositories\example\profiles\report.cvs
```

### 5. Return a oauth token

json
```
{
  "access_token": "XisfsJLkT_EY45Jsy6krRN_mXeaHQQSNW9kYwIb8qybsMIYevxXI7CUZcjoyJk-OEt5ST8T5Pw4W6FhQfu3liw",
  "scope": "ALL",
  "token_type": "bearer",
  "expires_in": 299
}

```

url
```
http://localhost:17000/example/login/oauth/token?grant_type=client_credentials&client_id=bbrtchc001&client_secret=chcbb001ec4y&scope=ALL
```

path of mock json on filesystem
```
mock-server-web\src\main\resources\repositories\example\login\loginTokenResponse
```

## Ideas for improvement
- Add ability to edit mock files online
- Add module for generation mock files based on json schema
- Add module for generating Controllers based on raml specification of rest endpoints
- Provide ability of manage your own mock server (online) as a service
