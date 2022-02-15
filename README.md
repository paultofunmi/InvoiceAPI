# Simple Invoice API
 
Application build and dependencies are managed by [Maven](https://maven.apache.org) which provides support to teams build, automate and deliver better software, faster.

## Endpoints
- GET: http://localhost:8081/api/v1/invoices
- POST: http://localhost:8081/api/v1/invoices
- Swagger: http://localhost:8081/api/swagger-ui.html#!/

## Application Properties

| Name                          | Default value                                                | Description                                                |
| ----------------------------- | ------------------------------------------------------------ | -----------------------------------------------------------|
| `PROJECT_VERSION`             | `1.0-SNAPSHOT`                                               | Project version                                            |
| `server.port`                 | `8081`                                                       | Port App starts on                                         |
| `database`                    | `h2 database`                                                | Datasource URL                                             |
| `spring.datasource.username`  | `assessment`                                                 | Datasource username                                        |
| `spring.datasource.password`  | `assessment`                                                 | Datasource password                                        |

## TL;DR

### Requirements

- Minimum JDK 8

### Example Commands

```sh
mvn clean
```

```sh
mvn install
```

