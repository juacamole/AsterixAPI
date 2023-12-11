# Server mit integrierter Datenbank 

## Controller

``` java
@RestController
@RequestMapping("url-pfad")
@RequiredArgsConstructor
public class ControllerName {

    private final ServiceName service;
    
    //GetMapping, Putmapping, etc. commands hier
    
    }
```

## Service

``` java
@Service
@RequiredArgsConstructor
public class ServiceName {

    private final RepositoryName repo;

    //GetMapping, Putmapping, etc. commands hier
}

```

## Repository

``` java
public interface RepositoryName extends MongoRepository<Datentyp, Datentyp>{}
```

## Datenbank

MongoDB Datenbank erstellen über MongoDB Compass

``` java
spring.data.mongodb.uri=mongodb://localhost:27017/DatenbankName
```

in die application.properties einfügen